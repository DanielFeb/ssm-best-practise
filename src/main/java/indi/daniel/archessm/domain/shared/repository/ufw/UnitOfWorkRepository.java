package indi.daniel.archessm.domain.shared.repository.ufw;

public interface UnitOfWorkRepository<T> {
    default void store(T entity){
        throw new UnsupportedOperationException();
    }
    void create(T entity);
    void modify(T entity);
    void remove(T entity);
}
