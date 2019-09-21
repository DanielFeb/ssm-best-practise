package indi.daniel.archessm.common.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import indi.daniel.archessm.common.ApplicationConstants;
import indi.daniel.archessm.common.exception.ApiException;
import indi.daniel.archessm.common.exception.UnexpectedServerErrorException;
import indi.daniel.archessm.common.log.LogMessageSupplier;
import indi.daniel.archessm.common.response.ServiceResponse;
import indi.daniel.archessm.common.response.ServiceResponseFactory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Log
public class ResponseWrapperAspect implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler
    @ResponseBody
    public ServiceResponse handleException(Exception e) {
        if (e instanceof ApiException) {
            return ServiceResponseFactory.constructApiExceptionResponse((ApiException) e);
        } else {
            UnexpectedServerErrorException ue = new UnexpectedServerErrorException(e);
            log.warning(()-> LogMessageSupplier.getMessage(ue));
            return ServiceResponseFactory.constructApiExceptionResponse(ue);
        }
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getDeclaringClass().getName().startsWith(ApplicationConstants.CONTROLLER_PACKAGE);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Object result;
        if (o instanceof ServiceResponse) {
            result = o;
        } else if (o instanceof  String) {
            try {
                result = objectMapper.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                UnexpectedServerErrorException ue = new UnexpectedServerErrorException(e);
                log.warning(()-> LogMessageSupplier.getMessage(ue));
                return ServiceResponseFactory.constructApiExceptionResponse(ue);
            }
        } else {
            result = ServiceResponseFactory.constructSuccessResponse(o);
        }
        return result;
    }
}
