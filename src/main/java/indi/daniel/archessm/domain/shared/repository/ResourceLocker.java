package indi.daniel.archessm.domain.shared.repository;

@Deprecated
//TODO improve this class with lambda and Lock
public interface ResourceLocker {
    boolean tryLock(String resourceUri);
    void unlock(String resourceUri);
}
