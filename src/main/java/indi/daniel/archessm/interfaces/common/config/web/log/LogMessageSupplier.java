package indi.daniel.archessm.interfaces.common.config.web.log;

import indi.daniel.archessm.interfaces.common.exception.ApiException;

public class LogMessageSupplier {
    public static String getMessage(ApiException ex) {
        return ex.toString();
    }
}
