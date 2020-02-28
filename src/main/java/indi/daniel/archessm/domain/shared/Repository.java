package indi.daniel.archessm.domain.shared;

public interface Repository<T, K extends Identity> {
    void store(T entity);
    void remove(T entity);
    T get(K id) throws EntityNotFoundException;
    K getNextId();
    boolean exists(K id);
}
