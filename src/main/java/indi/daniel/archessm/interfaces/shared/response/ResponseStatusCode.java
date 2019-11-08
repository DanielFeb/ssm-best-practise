package indi.daniel.archessm.interfaces.shared.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import indi.daniel.archessm.common.message.MessageCodeConstants;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

@ApiModel(value = "StatusCode", description = "Class of status")
public enum ResponseStatusCode {
    SUCCESS(10200, MessageCodeConstants.SUCCESS)
    , INVALID_ARGUMENT(10201, MessageCodeConstants.INVALID_ARGUMENT)
    , AUTH_ERROR(10202, MessageCodeConstants.AUTHORIZATION_ERROR)
    , BUSINESS_ERROR(10203, MessageCodeConstants.BUSINESS_ERROR)
    , UNEXPECTED_SERVER_ERROR(50001, MessageCodeConstants.UNEXPECTED_SERVER_ERROR);
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
        valueMap.put(AUTH_ERROR.toValue(), AUTH_ERROR);
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
