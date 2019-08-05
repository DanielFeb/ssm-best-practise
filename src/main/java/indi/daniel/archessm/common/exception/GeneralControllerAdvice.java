package indi.daniel.archessm.common.exception;

import indi.daniel.archessm.common.model.ServiceResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GeneralControllerAdvice {
    @ExceptionHandler
    @ResponseBody
    public ServiceResponse handleException(Exception e) throws Exception {
        // TODO
        throw e;
    }
}
