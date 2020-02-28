package indi.daniel.archessm.domain.shared;

public class DomainUtils {
    private DomainUtils() {}
    private static ResourceLocker RESOURCE_LOCKER;
    public static ResourceLocker getResourceLocker() {
        if (RESOURCE_LOCKER == null) {
            synchronized (ResourceLocker.class) {
                if (RESOURCE_LOCKER == null) {
                    RESOURCE_LOCKER = new LocalMapResourceLocker();
                }
            }
        }
        return RESOURCE_LOCKER;
    }
}
