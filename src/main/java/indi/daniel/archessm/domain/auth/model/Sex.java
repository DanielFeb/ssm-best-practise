package indi.daniel.archessm.domain.auth.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import indi.daniel.archessm.domain.shared.JsonSerializable;

import java.util.HashMap;
import java.util.Map;

public enum Sex implements JsonSerializable<Sex> {

    MALE(0, "male")
    , FEMALE(1, "female")
    , SECRET(2, "secret");
    private Integer value;
    private String description;

    Sex(Integer value, String description) {
        this.value = value;
        this.description = description;
    }


    private static Map<Integer, Sex> valueMap = new HashMap<>(Sex.values().length);

    static {
        valueMap.put(MALE.getValue(), MALE);
        valueMap.put(FEMALE.getValue(), FEMALE);
        valueMap.put(SECRET.getValue(), SECRET);
    }

    @JsonCreator
    public static Sex forValue(Integer value) {
        return valueMap.get(value);
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }

    @Override
    public String toJson() {
        return this.getValue().toString();
    }

    @Override
    public Sex fromJson(String json) {
        return valueMap.get(Integer.parseInt(json));
    }
}
