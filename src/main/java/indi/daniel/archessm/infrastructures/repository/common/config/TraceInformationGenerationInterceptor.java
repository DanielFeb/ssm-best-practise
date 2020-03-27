package indi.daniel.archessm.infrastructures.repository.common.config;

//TODO repository should not depends on interfaces

import indi.daniel.archessm.interfaces.auth.facade.UserServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class TraceInformationGenerationInterceptor {
    @Autowired
    private UserServiceFacade userServiceFacade;

    public static final String SET_CREATE_BY = "setCreateBy";
    public static final String SET_LAST_UPDATE_BY = "setLastUpdateBy";
    public static final String SET_CREATE_DATE = "setCreateDate";
    public static final String SET_LAST_UPDATE_DATE = "setLastUpdateDate";
    public static final Class IDENTITY_CLASS = Long.class;
    public static final Class DATE_CLASS = DateTime.class;


    @Pointcut("execution(* indi.daniel.archessm.infrastructures.repository..dao..insert*(..))")
    public void insertData() {
    }

    @Pointcut("execution(* indi.daniel.archessm.infrastructures.repository..dao..updateByPrimaryKey*(..))")
    public void updateData() {
    }

    @Before(value = "insertData() && args(arg1)")
    public void injectPropertiesWhenCreate(JoinPoint joinPoint, Object arg1) {
        Class clazz = arg1.getClass();
        DateTime now = DateTime.now();
        injectPropertyBySetter(arg1, clazz, SET_CREATE_BY, IDENTITY_CLASS, userServiceFacade.getCurrentUserId());
        injectPropertyBySetter(arg1, clazz, SET_LAST_UPDATE_BY, IDENTITY_CLASS, userServiceFacade.getCurrentUserId());
        injectPropertyBySetter(arg1, clazz, SET_CREATE_DATE, DATE_CLASS, now);
        injectPropertyBySetter(arg1, clazz, SET_LAST_UPDATE_DATE, DATE_CLASS, now);
    }


    @Before(value = "updateData() && args(arg1)")
    public void injectPropertiesWhenUpdate(JoinPoint joinPoint, Object arg1) {
        Class clazz = arg1.getClass();
        DateTime now = DateTime.now();
        injectPropertyBySetter(arg1, clazz, SET_CREATE_DATE, DATE_CLASS, now);
        injectPropertyBySetter(arg1, clazz, SET_LAST_UPDATE_DATE, DATE_CLASS, now);
    }

    private void injectPropertyBySetter(Object arg1, Class clazz, String setterName, Class paramClass, Object paramValue) {
        try {
            Method method = clazz.getDeclaredMethod(setterName, new Class[] {paramClass});
            method.invoke(arg1, paramValue);
        } catch (Exception e) {
            log.warn("注入"+ setterName + "失败");
        }
    }

}
