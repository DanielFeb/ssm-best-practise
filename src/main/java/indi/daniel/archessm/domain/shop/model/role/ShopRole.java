package indi.daniel.archessm.domain.shop.model.role;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ShopRole {

    ADMIN("SHOP.ADMIN")
    , OWNER("SHOP.OWNER")
    , ACCOUNTANT("SHOP.ACCOUNTANT")
    , CHIEF("SHOP.CHIEF")
    , WAITER("SHOP.WAITER")
    , CONSUMER("SHOP.CONSUMER")
    ;
    private Long id;
    private String name;

    ShopRole(String name) {
        this.name = name;
    }


    private static Map<String, ShopRole> valueMap = new HashMap<>(ShopRole.values().length);

    static {
        valueMap.put(ADMIN.toValue(), ADMIN);
        valueMap.put(OWNER.toValue(), OWNER);
        valueMap.put(ACCOUNTANT.toValue(), ACCOUNTANT);
        valueMap.put(CHIEF.toValue(), CHIEF);
        valueMap.put(WAITER.toValue(), WAITER);
        valueMap.put(CONSUMER.toValue(), CONSUMER);
    }

    @JsonCreator
    public static ShopRole forValue(String value) {
        return valueMap.get(value);
    }

    @JsonValue
    public String toValue() {
        return this.getName();
    }

    public String getName() {
        return name;
    }
}
