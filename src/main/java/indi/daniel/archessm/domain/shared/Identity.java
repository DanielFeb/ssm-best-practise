package indi.daniel.archessm.domain.shared;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public abstract class Identity<T, V> implements ValueObject<Identity<T, V>> {
    private V value;

    public Identity(V value) {
        Assert.notNull(value, "Identity cannot be null!");
        this.value = value;
    }

    @Override
    public boolean sameValueAs(Identity<T, V> other) {
        return this == other || value.equals(other.value);
    }
}
