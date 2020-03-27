package indi.daniel.archessm.domain.shared.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public class LocalMapResourceLocker implements ResourceLocker {
    private static Map<String, Thread> lockRegistry = new ConcurrentHashMap<>();

    @Override
    public boolean tryLock(String resourceUri) {
        lockRegistry.putIfAbsent(resourceUri, Thread.currentThread());
        return lockRegistry.get(resourceUri) == Thread.currentThread();
    }

    @Override
    public void unlock(String resourceUri) {
        Thread ownerThread = lockRegistry.get(resourceUri);
        if (ownerThread == Thread.currentThread()) {
            lockRegistry.remove(resourceUri);
        }
    }
}
