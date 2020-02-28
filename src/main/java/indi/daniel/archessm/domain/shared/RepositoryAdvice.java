package indi.daniel.archessm.domain.shared;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RepositoryAdvice {

    @Pointcut("execution(* *..*domain.shared.Repository.store(..))")
    public void storePointCut(){
    }

    @Around("storePointCut()")
    public void timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Entity entity = (Entity) joinPoint.getArgs()[0];
        entity.verify();
        joinPoint.proceed();
    }
}
