package indi.daniel.archessm.domain.shared.repository;

import indi.daniel.archessm.domain.shared.core.Entity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class RepositoryAdvice {
    public static final String REPOSITORY_PATH = "*..*domain.shared.repository.Repository";

    @Pointcut("execution(* *..*domain.shared.repository.Repository.store(..))" +
            " || execution(* *..*UnitOfWorkRepository.create(..))" +
            " || execution(* *..*UnitOfWorkRepository.modify(..))")
    public void storePointCut(){
    }

    @Around("storePointCut()")
    public Object doStoreAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Entity entity = (Entity) joinPoint.getArgs()[0];
        entity.verify();
        return joinPoint.proceed();
    }



    //TODO traceInformation
}
