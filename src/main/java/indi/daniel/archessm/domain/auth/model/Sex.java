package indi.daniel.archessm.domain.auth.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Sex {

    MALE(0, "male")
    , FEMALE(1, "female")
    , SECRET(2, "secret");
    private Integer value;
    private String description;

    Sex(Integer value, String description) {
        this.value = value;
        this.description = description;
    }


    private static Map<String, Sex> valueMap = new HashMap<>(Sex.values().length);

    static {
        valueMap.put(MALE.toValue(), MALE);
        valueMap.put(FEMALE.toValue(), FEMALE);
        valueMap.put(SECRET.toValue(), SECRET);
    }

    @JsonCreator
    public static Sex forValue(String value) {
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
