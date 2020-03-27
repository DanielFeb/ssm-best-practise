package indi.daniel.archessm.domain.shared.repository;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.domain.shared.core.Entity;
import indi.daniel.archessm.domain.shared.core.Identity;

import java.util.Objects;

public interface SimplifiedRepository<T extends Entity<?, K>, K extends Identity>  extends Repository<T, K> {
    @Override
    default void store(T entity) {
        Preconditions.checkArgument(Objects.nonNull(entity));
        if (exists(entity)) {
            doModify(entity);
        } else {
            doCreate(entity);
        }
    }

    @Override
    default void create(T entity) {
        Preconditions.checkArgument(Objects.nonNull(entity));
        if (exists(entity)) {
            throw new EntityAlreadyExistsException(getEntityName());
        }
        doCreate(entity);
    }

    @Override
    default void modify(T entity) {
        Preconditions.checkArgument(Objects.nonNull(entity));
        if (!exists(entity)) {
            throw new EntityNotFoundException(getEntityName());
        }
        doModify(entity);

    }

    @Override
    default void remove(T entity) {
        Preconditions.checkArgument(Objects.nonNull(entity));
        if (!exists(entity)) {
            throw new EntityNotFoundException(getEntityName());
        }
        doRemove(entity);
    }

    @Override
    default T get(K id) throws EntityNotFoundException {
        Preconditions.checkArgument(Objects.nonNull(id));
        T entity = doGet(id);
        if (entity == null) {
            throw new EntityNotFoundException(getEntityName());
        }
        return entity;
    }

    void doCreate(T entity);
    void doModify(T entity);
    void doRemove(T entity);
    String getEntityName();
    T doGet(K id);
}
