package indi.daniel.archessm.domain.shared;

public interface ResourceLocker {
    boolean tryLock(String resourceUri);
    void unlock(String resourceUri);
}
