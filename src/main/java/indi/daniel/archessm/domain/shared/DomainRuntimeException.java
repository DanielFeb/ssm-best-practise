package indi.daniel.archessm.domain.shared;


import lombok.Getter;

@Getter
public class DomainRuntimeException extends RuntimeException {

    private String messageCode;

    public DomainRuntimeException(String messageCode) {
        this.messageCode = messageCode;
    }

    public DomainRuntimeException(String messageCode, Throwable cause) {
        super(cause);
        this.messageCode = messageCode;
    }
}
