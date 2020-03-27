package indi.daniel.archessm.domain.shared.repository;

import indi.daniel.archessm.domain.shared.core.DomainRuntimeException;

public class EntityAlreadyExistsException extends DomainRuntimeException {
    public EntityAlreadyExistsException(String entityName) {
        this(entityName, null);
    }

    public EntityAlreadyExistsException(String entityName, Throwable cause) {
        super(entityName + "已经存在", cause);
    }
}
