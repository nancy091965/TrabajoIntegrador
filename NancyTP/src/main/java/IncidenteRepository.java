
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public class IncidenteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void guardarIncidente(Incidente incidente) {
        entityManager.persist(incidente);
    }

    public Incidente obtenerIncidentePorId(Long id) {
        return entityManager.find(Incidente.class, id);
    }

    public List<Incidente> obtenerIncidentesResueltosEnUltimosDias(int dias) {
        LocalDate fechaLimite = LocalDate.now().minusDays(dias);

        String jpql = "SELECT i FROM Incidente i " +
                "WHERE i.fechaResolucion IS NOT NULL " +
                "AND i.fechaResolucion >= :fechaLimite";

        return entityManager.createQuery(jpql, Incidente.class)
                .setParameter("fechaLimite", fechaLimite.atStartOfDay())
                .getResultList();
    }


}


