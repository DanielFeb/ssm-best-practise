package indi.daniel.archessm.common.interfaces.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(value = "Response body", description = "Standard format of response")
public class ServiceResponse<T> {
    private T result;
    private ResponseStatus status;
}
