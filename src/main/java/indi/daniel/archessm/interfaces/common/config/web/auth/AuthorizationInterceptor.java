package indi.daniel.archessm.interfaces.common.config.web.auth;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // your authorization check
        return true;
    }

    // define your ignore path here
    public String[] getIgnorePath() {
        return new String[]{};
    }
}
