package indi.daniel.archessm.common.exception;

import lombok.Getter;

@Getter
public class DomainException extends Exception {
    private String messageCode;

    public DomainException(String messageCode) {
        this.messageCode = messageCode;
    }

    public DomainException(String messageCode, Throwable cause) {
        super(cause);
        this.messageCode = messageCode;
    }
}
