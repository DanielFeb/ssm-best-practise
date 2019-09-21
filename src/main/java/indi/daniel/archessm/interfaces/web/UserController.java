package indi.daniel.archessm.interfaces.web;

import indi.daniel.archessm.common.SwaggerConstants;
import indi.daniel.archessm.interfaces.facade.dto.UserDTO;
import indi.daniel.archessm.repository.po.UserPO;
import indi.daniel.archessm.interfaces.facade.UserServiceFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "UserDTO information API", description = "APIS for user information management and query", tags = "UserApi", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserServiceFacade userServiceFacade;

    @ApiOperation(value = SwaggerConstants.GET_USER, notes = "Query user by id ")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDTO getUser(@RequestParam("id") Long id) {
        return userServiceFacade.getUser(id);
    }

    @ApiOperation(value = SwaggerConstants.ADD_USER, notes = "Add a userDTO")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        userDTO.setId(userServiceFacade.addUser(userDTO));
        return userDTO;
    }
}
