package indi.daniel.archessm.domain.shared.repository.ufw;

public interface UnitOfWorkRepository<T> {
    void create(T entity);
    void modify(T entity);
    void remove(T entity);
}
