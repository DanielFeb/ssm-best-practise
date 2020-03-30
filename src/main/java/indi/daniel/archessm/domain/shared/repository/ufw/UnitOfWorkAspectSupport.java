package indi.daniel.archessm.domain.shared.repository.ufw;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import javax.annotation.Nullable;

@Aspect
@Slf4j
public class UnitOfWorkAspectSupport {

    @Pointcut("execution(void *..*UnitOfWorkRepository.create(..))" +
            "|| execution(void *..*UnitOfWorkRepository.modify(..))" +
            "|| execution(void *..*UnitOfWorkRepository.remove(..))" +
            "|| execution(void *..*UnitOfWorkRepository.store(..))")
    public void opsPointCut(){
    }


    private static final ThreadLocal<UnitOfWorkAspectSupport.UnitOfWorkInfo> unitOfWorkInfoHolder =
            new ThreadLocal<>();

    @Around("opsPointCut() && args(entity,..) && target(repository)")
    public void doCreateAdvice(ProceedingJoinPoint joinPoint, Object entity, UnitOfWorkRepository repository) throws Throwable {
        //TODO add operation to UnitOfWork
        UnitOfWorkInfo unitOfWorkInfo = getUnitOfWorkInfoIfExists();
        if ( unitOfWorkInfo == null) {
            joinPoint.proceed();
        } else {
            String methodName = joinPoint.getSignature().getName();
            log.debug("Delay operation, " +
                    joinPoint.getTarget().getClass().getName() + ":" + methodName);
            switch (methodName) {
                case "create":
                    unitOfWorkInfo.registerNew(entity, repository);
                    break;
                case "modify":
                    unitOfWorkInfo.registerModified(entity, repository);
                    break;
                case "remove":
                    unitOfWorkInfo.registerRemoved(entity, repository);
                    break;
                case "store":
                    unitOfWorkInfo.registerStore(entity, repository);
                    break;
                default:
                    throw new UnsupportedOperationException(methodName);
            }
        }

    }


    @Pointcut("@annotation(DelayCommit)")
    public void delayCommitPointCut(){
    }

    @Around("delayCommitPointCut() && @annotation(delayCommit)")
    public Object delayCommit(ProceedingJoinPoint joinPoint, DelayCommit delayCommit) throws Throwable {
        log.debug("Create unit of work");
        UnitOfWorkInfo oldUnitOfWorkInfo = getUnitOfWorkInfoIfExists();
        UnitOfWorkInfo unitOfWorkInfo = createUnitOfWorkInfoIfNecessary(delayCommit.propagation());
        try {
            //create UnitOfWork here
            Object result = joinPoint.proceed();

            //commit UnitOfWork here
            if (oldUnitOfWorkInfo != unitOfWorkInfo) {
                log.debug("Commit unit of work");
                unitOfWorkInfo.commit();
            }
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            if (oldUnitOfWorkInfo != unitOfWorkInfo) {
                unitOfWorkInfo.bindOldToThread();
            }
        }
    }

    private UnitOfWorkInfo getUnitOfWorkInfoIfExists() {
        return unitOfWorkInfoHolder.get();
    }

    private UnitOfWorkInfo createUnitOfWorkInfoIfNecessary(DelayPropagation delayPropagation) {
        if (delayPropagation == DelayPropagation.IMMEDIATE) {
            return createNewUnitOfWorkInfo();
        } else  {
            UnitOfWorkInfo unitOfWorkInfo = unitOfWorkInfoHolder.get();
            if ( unitOfWorkInfo == null) {
                return createNewUnitOfWorkInfo();
            }
            return unitOfWorkInfo;
        }
    }

    private UnitOfWorkInfo createNewUnitOfWorkInfo() {
        UnitOfWorkInfo unitOfWorkInfo = new UnitOfWorkInfo();
        unitOfWorkInfo.bindToThread();
        return unitOfWorkInfo;
    }

    protected final class UnitOfWorkInfo implements UnitOfWork {
        @Nullable
        private UnitOfWorkInfo oldUnitOfWorkInfo;
        private UnitOfWork unitOfWork;
        private UnitOfWorkInfo() {
            unitOfWork = UnitOfWorkFactory.getInstance().createUnitOfWork();
        }

        private void bindToThread() {
            // for restoration after this UnitOfWorkInfo is complete.
            this.oldUnitOfWorkInfo = unitOfWorkInfoHolder.get();
            unitOfWorkInfoHolder.set(this);
        }

        private void bindOldToThread() {
            unitOfWorkInfoHolder.set(this.oldUnitOfWorkInfo);
        }

        @Override
        public <T> void registerStore(T entity, UnitOfWorkRepository<T> repository) {
            unitOfWork.registerStore(entity, repository);
        }

        @Override
        public <T> void registerNew(T entity, UnitOfWorkRepository<T> repository) {
            unitOfWork.registerNew(entity, repository);
        }

        @Override
        public <T> void registerModified(T entity, UnitOfWorkRepository<T> repository) {
            unitOfWork.registerModified(entity, repository);
        }

        @Override
        public <T> void registerRemoved(T entity, UnitOfWorkRepository<T> repository) {
            unitOfWork.registerRemoved(entity, repository);
        }

        @Override
        public void commit() {
            unitOfWork.commit();
        }
    }
}
