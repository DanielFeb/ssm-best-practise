package indi.daniel.archessm.domain.shared.repository;

// TODO dlc + lambda
// TODO build ResourceUri class
public interface ResourceLocker {
    boolean tryLock(String resourceUri);
    void unlock(String resourceUri);
}
