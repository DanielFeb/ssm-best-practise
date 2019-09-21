package indi.daniel.archessm.repository;

import indi.daniel.archessm.repository.dao.IdentityMapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class LocalMapIdentityGenerator implements IdentityGenerator {
    private final IdentityMapper identityMapper;
    private final Map<String, AtomicLong> keyIdMap;

    private LocalMapIdentityGenerator(IdentityMapper identityMapper) {
        this.identityMapper = identityMapper;
        this.keyIdMap = new ConcurrentHashMap<>();
    }

    private static volatile  LocalMapIdentityGenerator instance;

    public static LocalMapIdentityGenerator getInstance(IdentityMapper identityMapper) {
        if (null == instance) {
            synchronized (LocalMapIdentityGenerator.class) {
                if (null == instance) {
                    instance = new LocalMapIdentityGenerator(identityMapper);
                }
            }
        }
        return instance;
    }

    @Override
    public Long getNextId(String tableName) {
        AtomicLong idCounter = keyIdMap.get(tableName);
        if (null == idCounter) {
            synchronized (keyIdMap) {
                idCounter = keyIdMap.get(tableName);
                if (null == idCounter) {
                    idCounter = new AtomicLong(identityMapper.getNextID(tableName));
                    keyIdMap.put(tableName, idCounter);
                    return idCounter.get();
                }
            }
        }
        return idCounter.addAndGet(1L);
    }
}
