package indi.daniel.archessm.domain.shared.repository;

import indi.daniel.archessm.domain.shared.core.DomainRuntimeException;

public class EntityNotFoundException extends DomainRuntimeException {
    public EntityNotFoundException(String entityName) {
        this(entityName, null);
    }

    public EntityNotFoundException(String entityName, Throwable cause) {
        super(entityName + "不存在", cause);
    }
}
