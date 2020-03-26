package indi.daniel.archessm.domain.shared;

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
