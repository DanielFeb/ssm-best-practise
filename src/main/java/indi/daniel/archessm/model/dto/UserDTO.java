package indi.daniel.archessm.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "UserDTO", description = "UserDTO information")
public class UserDTO {

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
