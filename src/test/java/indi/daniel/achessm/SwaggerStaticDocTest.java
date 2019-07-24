package indi.daniel.achessm;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import indi.daniel.archessm.BootStrapApplication;
import indi.daniel.archessm.common.SwaggerConstants;
import indi.daniel.archessm.controller.UserController;
import indi.daniel.archessm.model.User;
import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import springfox.documentation.staticdocs.SwaggerResultHandler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebAppConfiguration
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootStrapApplication.class})
public class SwaggerStaticDocTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserController userController;


    @After
    public void Test() throws Exception {
        String outputDir = "target/asciidoc";
        mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
                .andExpect(status().isOk())
                .andReturn();

        String snippetDir = "target/generated-snippets";
        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
                .withPathsGroupedBy(GroupBy.TAGS)
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withExamples(snippetDir)
                .build()
                .intoFolder(outputDir);
    }

    @Test
    public void TestApi() throws Exception {

        User user = new User();
        user.setId(123456);
        user.setName("Daniel");
        user.setAge(25);
        user.setAddress("Shanghai China");
        user.setSex("MALE");

        given(userController.getUser(any())).willReturn(user);
        mockMvc.perform(get("/user").param("name", "Daniel")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcRestDocumentation.document(SwaggerConstants.GET_USER, preprocessResponse(prettyPrint())));

        given(userController.addUser(any())).willReturn(user);
        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(user, SerializerFeature.PrettyFormat))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document(SwaggerConstants.ADD_USER, preprocessResponse(prettyPrint())));
    }


}
