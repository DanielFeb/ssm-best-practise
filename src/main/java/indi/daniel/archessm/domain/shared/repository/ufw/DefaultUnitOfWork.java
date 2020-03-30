package indi.daniel.archessm.domain.shared.repository.ufw;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class DefaultUnitOfWork implements UnitOfWork {

    protected DefaultUnitOfWork() {
        operationList = new LinkedList<>();
    }

    private List<Operation> operationList;

    @Override
    public <T> void registerStore(T entity, UnitOfWorkRepository<T> repository) {
        operationList.add(new Operation(OperationType.STORE, entity, repository));
    }

    @Override
    public <T> void registerNew(T entity, UnitOfWorkRepository<T> repository) {
        operationList.add(new Operation(OperationType.CREATE, entity, repository));
    }

    @Override
    public <T> void registerModified(T entity, UnitOfWorkRepository<T> repository) {
        operationList.add(new Operation(OperationType.MODIFY, entity, repository));

    }

    @Override
    public <T> void registerRemoved(T entity, UnitOfWorkRepository<T> repository) {
        operationList.add(new Operation(OperationType.REMOVE, entity, repository));

    }

    private enum OperationType {
        CREATE,
        MODIFY,
        REMOVE,
        STORE
    }

    @AllArgsConstructor
    @Getter
    private final class Operation<T> {
        private OperationType type;
        private T entity;
        private UnitOfWorkRepository<T> repository;
    }

    @Override
    public void commit() {
        for (Operation operation : operationList) {
            switch (operation.type) {
                case CREATE:
                    operation.getRepository().create(operation.getEntity()); break;
                case MODIFY:
                    operation.getRepository().modify(operation.getEntity()); break;
                case REMOVE:
                    operation.getRepository().remove(operation.getEntity()); break;
                case STORE:
                    operation.getRepository().store(operation.getEntity()); break;
            }
        }
    }
}
