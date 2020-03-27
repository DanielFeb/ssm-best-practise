package indi.daniel.archessm.domain.shared.core;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Identity<T, V> implements ValueObject<Identity<T, V>> {
    private V value;

    public Identity(V value) {
        Preconditions.checkArgument(value != null);
        this.value = value;
    }

    @Override
    public boolean sameValueAs(Identity<T, V> other) {
        return this == other || value.equals(other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identity)) return false;
        Identity<?, ?> identity = (Identity<?, ?>) o;
        return Objects.equals(getValue(), identity.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
