import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.concurrent.atomic.AtomicReference;

public class JPAanotacion {


    private static final AtomicReference<EntityManagerFactory> entityManagerFactory = new AtomicReference<>();

    public static EntityManager getEntityManager() {
        if (entityManagerFactory.get() == null) {
            entityManagerFactory.set(Persistence.createEntityManagerFactory("TpNancy"));
        }
        return entityManagerFactory.get().createEntityManager();
    }

    public static void main(String[] args) {
        try (EntityManager en = getEntityManager()) {
            getEntityManager();
            en.getTransaction().begin();
            Tecnico t1 = new Tecnico();
            t1.setNombre(" Alvarez");
            t1.setEspecialidad("conectividad");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}