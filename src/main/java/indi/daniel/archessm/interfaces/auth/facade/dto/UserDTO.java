package indi.daniel.archessm.interfaces.auth.facade.dto;

import indi.daniel.archessm.domain.auth.model.Sex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "UserDTO", description = "UserDTO information")
public class UserDTO {

    @ApiModelProperty("identification code")
    private Long id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("password")
    private String password;

    @ApiModelProperty("age")
    private int age;

    @ApiModelProperty("sex")
    private Sex sex;

    @ApiModelProperty("home address")
    private String address;

}
