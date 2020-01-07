package indi.daniel.archessm.interfaces.common.response;

import indi.daniel.archessm.interfaces.common.exception.ApiException;
import indi.daniel.archessm.common.message.MessageCodeConstants;

public class ServiceResponseFactory {
    private ServiceResponseFactory() { }
    public static final ResponseStatus DEFAULT_SUCCESS_RESPONSE_STATUS =
            ResponseStatusFactory.get(ResponseStatusCode.SUCCESS, MessageCodeConstants.SUCCESS);
    public static final String EMPTY_RESULT = "";
    public static <T> ServiceResponse<T> constructSuccessResponse(T result) {
        return new ServiceResponse<>(result, DEFAULT_SUCCESS_RESPONSE_STATUS);
    }
    public static  ServiceResponse<?> constructApiExceptionResponse(ApiException ex) {
        return new ServiceResponse<>(EMPTY_RESULT,
                ResponseStatusFactory.get(ex.getCode(), ex.getMessageCode(), ex.getDetail()));
    }
}
