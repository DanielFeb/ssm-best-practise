package indi.daniel.archessm.interfaces.auth.web.config.log;

import indi.daniel.archessm.common.interfaces.exception.ApiException;

public class LogMessageSupplier {
    public static String getMessage(ApiException ex) {
        return ex.toString();
    }
}
