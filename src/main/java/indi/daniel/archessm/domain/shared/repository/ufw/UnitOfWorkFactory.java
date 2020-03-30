package indi.daniel.archessm.domain.shared.repository.ufw;

public class UnitOfWorkFactory {
    private UnitOfWorkFactory() {}

    private static UnitOfWorkFactory INSTANCE;

    public static UnitOfWorkFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (UnitOfWorkFactory.class) {
                if(INSTANCE == null) {
                    INSTANCE = new UnitOfWorkFactory();
                }
            }
        }
        return INSTANCE;
    }

    public UnitOfWork createUnitOfWork() {
        return new DefaultUnitOfWork();
    }
}
