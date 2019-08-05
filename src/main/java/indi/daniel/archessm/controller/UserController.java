package indi.daniel.archessm.controller;

import indi.daniel.archessm.common.SwaggerConstants;
import indi.daniel.archessm.model.dto.UserDTO;
import indi.daniel.archessm.model.po.User;
import indi.daniel.archessm.service.UserService;
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
    private UserService userService;

    @ApiOperation(value = SwaggerConstants.GET_USER, notes = "Query user by name ")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDTO getUser(@RequestParam("name") String name) {
        return new UserDTO();
    }

    @ApiOperation(value = SwaggerConstants.ADD_USER, notes = "Add a userDTO")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
//        user.setAge(userDTO.getAge());
        user.setName(userDTO.getName());
        user.setSex(userDTO.getSex());
        user.setAddress(userDTO.getAddress());
        userService.addUser(user);
        userDTO.setId(user.getId());
        return userDTO;
    }
}
