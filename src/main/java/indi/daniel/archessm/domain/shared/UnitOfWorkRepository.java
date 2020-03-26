package indi.daniel.archessm.domain.shared;

public interface UnitOfWorkRepository<T> {
    void create(T entity);
    void modify(T entity);
    void remove(T entity);
}
