package indi.daniel.archessm.domain.shared.repository;

import indi.daniel.archessm.domain.shared.core.DomainRuntimeException;

public class DirtyDataException extends DomainRuntimeException {
    public DirtyDataException(String messageCode) {
        super(messageCode);
    }

    public DirtyDataException(String messageCode, Throwable cause) {
        super(messageCode, cause);
    }

    public DirtyDataException(Throwable cause) {
        super("脏数据哦！", cause);
    }
}
