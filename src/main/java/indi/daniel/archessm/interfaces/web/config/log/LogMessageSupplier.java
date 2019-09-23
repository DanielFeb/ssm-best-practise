package indi.daniel.archessm.interfaces.web.config.log;

import indi.daniel.archessm.interfaces.shared.exception.ApiException;

public class LogMessageSupplier {
    public static String getMessage(ApiException ex) {
        return ex.toString();
    }
}
