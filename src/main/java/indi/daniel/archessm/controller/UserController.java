package indi.daniel.archessm.controller;

import indi.daniel.archessm.common.SwaggerConstants;
import indi.daniel.archessm.model.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "UserDTO information API", description = "APIS for user information management and query", tags = "UserApi", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @ApiOperation(value = SwaggerConstants.GET_USER, notes = "Query user by name ")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDTO getUser(@RequestParam("name") String name) {
        return null;
    }

    @ApiOperation(value = SwaggerConstants.ADD_USER, notes = "Add a userDTO")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDTO addUser(@RequestBody UserDTO userDTO) {

        return null;
    }
}
