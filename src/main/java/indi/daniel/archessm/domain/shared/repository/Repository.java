package indi.daniel.archessm.domain.shared.repository;

import indi.daniel.archessm.domain.shared.core.Entity;
import indi.daniel.archessm.domain.shared.core.Identity;
import indi.daniel.archessm.domain.shared.repository.ufw.UnitOfWorkRepository;

public interface Repository<T extends Entity<?, K>, K extends Identity> extends UnitOfWorkRepository<T> {
    default void store(T entity) {
        if (exists(entity)) {
            modify(entity);
        } else {
            create(entity);
        }
    }

    void remove(T entity);
    T get(K id) throws EntityNotFoundException;
    K getNextId();
    boolean exists(K id);
    default boolean exists(T entity) {
        return exists(entity.id());
    }
}
