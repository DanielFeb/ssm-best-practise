package indi.daniel.archessm.common.interfaces.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(value = "Status", description = "Success or error information")
public class ResponseStatus {
    @ApiModelProperty("Status Code")
    private ResponseStatusCode code;
    @ApiModelProperty("Message")
    private String message;
    @ApiModelProperty("Detail info")
    private String detail;
}
