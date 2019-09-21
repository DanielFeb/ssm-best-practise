package indi.daniel.archessm.common.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

@ApiModel(value = "StatusCode", description = "Class of status")
public enum ResponseStatusCode {
    SUCCESS(10200, "Success")
    , INVALID_ARGUMENT(10201, "Invalid Argument")
    , AUTHENTICATION_ERROR(10202, "Authentication Error")
    , UNEXPECTED_SERVER_ERROR(50001, "Unexpected Server Error");
    private Integer value;
    private String description;

    ResponseStatusCode(Integer value, String description) {
        this.value = value;
        this.description = description;
    }


    private static Map<String, ResponseStatusCode> valueMap = new HashMap<>(ResponseStatusCode.values().length);

    static {
        valueMap.put(SUCCESS.toValue(), SUCCESS);
        valueMap.put(INVALID_ARGUMENT.toValue(), INVALID_ARGUMENT);
        valueMap.put(AUTHENTICATION_ERROR.toValue(), AUTHENTICATION_ERROR);
        valueMap.put(UNEXPECTED_SERVER_ERROR.toValue(), UNEXPECTED_SERVER_ERROR);
    }

    @JsonCreator
    public static ResponseStatusCode forValue(String value) {
        return valueMap.get(value);
    }

    @JsonValue
    public String toValue() {
        return this.getValue().toString();
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
