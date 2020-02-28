package indi.daniel.archessm.interfaces.common.config.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import indi.daniel.archessm.domain.shared.DomainRuntimeException;
import indi.daniel.archessm.interfaces.common.exception.ApiException;
import indi.daniel.archessm.interfaces.common.exception.UnexpectedServerErrorException;
import indi.daniel.archessm.interfaces.common.response.ResponseStatusCode;
import indi.daniel.archessm.interfaces.common.response.ServiceResponse;
import indi.daniel.archessm.interfaces.common.response.ServiceResponseFactory;
import indi.daniel.archessm.interfaces.common.config.web.log.LogMessageSupplier;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Nonnull;

@ControllerAdvice
@Slf4j
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object> {
    private final ObjectMapper objectMapper;

    @Autowired
    public ResponseWrapperAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler
    @ResponseBody
    public ServiceResponse handleException(Exception e) {
        if (e instanceof ApiException) {
            return ServiceResponseFactory.constructApiExceptionResponse((ApiException) e);
        } else if (e instanceof DomainRuntimeException) {
            return ServiceResponseFactory.constructApiExceptionResponse(new ApiException(ResponseStatusCode.BUSINESS_ERROR, (DomainRuntimeException) e));
        }  else if (e instanceof MethodArgumentNotValidException) {
            // handle controller argument validation error. Avoid 400
            return ServiceResponseFactory.constructApiExceptionResponse(new ApiException(ResponseStatusCode.INVALID_ARGUMENT, e.getMessage(), e));
        } else {
            UnexpectedServerErrorException ue = new UnexpectedServerErrorException(e);
            log.warn(LogMessageSupplier.getMessage(ue));
            return ServiceResponseFactory.constructApiExceptionResponse(ue);
        }
    }

    @Override
    public boolean supports(@Nonnull MethodParameter methodParameter, @Nonnull Class<? extends HttpMessageConverter<?>> aClass) {
        // TODO： ant匹配
        return methodParameter.getDeclaringClass().getName().startsWith(WebConstants.CONTROLLER_PACKAGE);
    }

    @Override
    public Object beforeBodyWrite(Object o, @Nonnull MethodParameter methodParameter,
                                  @Nonnull MediaType mediaType,
                                  @Nonnull Class<? extends HttpMessageConverter<?>> aClass,
                                  @Nonnull ServerHttpRequest serverHttpRequest,
                                  @Nonnull ServerHttpResponse serverHttpResponse) {
        Object result;
        if (o instanceof ServiceResponse) {
            result = o;
        } else if (o instanceof  String) {
            try {
                result = objectMapper.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                UnexpectedServerErrorException ue = new UnexpectedServerErrorException(e);
                log.warn(LogMessageSupplier.getMessage(ue));
                return ServiceResponseFactory.constructApiExceptionResponse(ue);
            }
        } else {
            result = ServiceResponseFactory.constructSuccessResponse(o);
        }
        return result;
    }
}
