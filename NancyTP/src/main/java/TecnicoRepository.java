
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class TecnicoRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public TecnicoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Object[]> obtenerTecnicosConMasIncidentesResueltos(int dias) {
        LocalDate fechaLimite = LocalDate.now().minusDays(dias);

        String jpql = "SELECT t, COUNT(i) " +
                "FROM Tecnico t " +
                "JOIN t.incidentes i " +
                "WHERE i.fechaResolucion >= :fechaLimite " +
                "GROUP BY t " +
                "ORDER BY COUNT(i) DESC";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("fechaLimite", fechaLimite.atStartOfDay());


        query.setMaxResults(5);

        return query.getResultList();
    }
}


