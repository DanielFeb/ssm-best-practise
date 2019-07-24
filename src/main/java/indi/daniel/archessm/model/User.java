package indi.daniel.archessm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "User", description = "User information")
public class User {

    @ApiModelProperty("identification code")
    private int id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("age")
    private int age;

    @ApiModelProperty("sex")
    private String sex;

    @ApiModelProperty("home address")
    private String address;

}
