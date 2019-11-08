package indi.daniel.archessm.interfaces.shared.exception;

import indi.daniel.archessm.domain.shared.DomainRuntimeException;
import indi.daniel.archessm.interfaces.shared.response.ResponseStatusCode;
import indi.daniel.archessm.domain.shared.DomainException;
import lombok.Data;

import java.io.PrintWriter;
import java.io.StringWriter;

@Data
public class ApiException extends RuntimeException {
    @Override
    public String toString() {
        return "ApiException{" +
                "code=" + code +
                ", messageCode='" + messageCode + '\'' +
                ", detail='" + this.getDetail() + '\'' +
                '}';
    }

    public ApiException(ResponseStatusCode code, DomainException e) {
        this(code, e.getMessageCode(), e);
    }


    public ApiException(ResponseStatusCode code, DomainRuntimeException e) {
        this(code, e.getMessageCode(), e);
    }

    public ApiException(ResponseStatusCode code, String messageCode) {
        this(code, messageCode, null);
    }

    public ApiException(ResponseStatusCode code, String messageCode, Throwable cause) {
        super(cause);
        this.code = code;
        this.messageCode = messageCode;
    }

    public String getDetail() {

        String detail;
        if (this.getCause() != null) {

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            this.getCause().printStackTrace(pw);
            detail = sw.toString();
        } else {
            detail = this.getCode().getDescription();
        }
        return detail;
    }

    private ResponseStatusCode code;
    private String messageCode;
}
