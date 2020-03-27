package indi.daniel.archessm.domain.shared.repository.ufw;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class UnitOfWorkInterceptor {

    @Pointcut("execution(* *..*UnitOfWorkRepository.create(..))")
    public void createPointCut(){
    }

    @Around("createPointCut()")
    public void doCreateAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

    }

}
