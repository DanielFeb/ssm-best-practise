package indi.daniel.archessm.domain.shared.repository.ufw;

public interface UnitOfWork {
    <T> void registerStore(T entity, UnitOfWorkRepository<T> repository);
    <T> void registerNew(T entity, UnitOfWorkRepository<T> repository);
    <T> void registerModified(T entity, UnitOfWorkRepository<T> repository);
    <T> void registerRemoved(T entity, UnitOfWorkRepository<T> repository);
    void commit();
}
