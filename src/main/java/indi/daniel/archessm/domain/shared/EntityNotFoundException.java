package indi.daniel.archessm.domain.shared;

public class EntityNotFoundException extends DomainRuntimeException {
    public EntityNotFoundException(String messageCode) {
        super(messageCode);
    }

    public EntityNotFoundException(String messageCode, Throwable cause) {
        super(messageCode, cause);
    }
}
