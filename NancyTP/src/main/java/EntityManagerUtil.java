

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.concurrent.atomic.AtomicReference;

public class EntityManagerUtil {

    private static final AtomicReference<EntityManagerFactory> entityManagerFactory = new AtomicReference<>();

    public static EntityManager getEntityManager() {
        if (entityManagerFactory.get() == null) {
            entityManagerFactory.set(Persistence.createEntityManagerFactory("TpNancy"));
        }
        return (EntityManager) entityManagerFactory.get().createEntityManager();
    }
}


