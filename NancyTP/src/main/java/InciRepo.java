
import java.util.List;

    public interface InciRepo {
    interface IncidenteRepository  {



        List<Incidente> findByTecnicoOrderByFechaResolucionDesc(Tecnico tecnico);

    }


}
