package indi.daniel.archessm.common.log;

import indi.daniel.archessm.common.exception.ApiException;

public class LogMessageSupplier {
    public static String getMessage(ApiException ex) {
        return ex.toString();
    }
}
