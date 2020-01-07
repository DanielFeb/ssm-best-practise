package indi.daniel.archessm.interfaces.common.config.web.log;

import indi.daniel.archessm.interfaces.common.config.web.WebConstants;
import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class ControllerLogAspect {
    @Pointcut("execution(public * " + WebConstants.CONTROLLER_PACKAGE + "*..*(..))")
    public void controllerPointCut(){
    }
    @Around("controllerPointCut()")
    public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTimeStamp = System.currentTimeMillis();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(joinPoint.getTarget().getClass().getName()).append(":")
                .append(joinPoint.getSignature().getName())
                .append(" Time Cost:").append((System.currentTimeMillis() - startTimeStamp)).append("ms!");
        log.info(stringBuilder.toString());
        return result;
    }

}
