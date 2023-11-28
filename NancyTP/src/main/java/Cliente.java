import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    // Otros atributos

    @OneToMany(mappedBy = "cliente")
    private List<MesaAyuda> mesasAyuda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MesaAyuda> getMesasAyuda() {
        return mesasAyuda;
    }

    public void setMesasAyuda(List<MesaAyuda> mesasAyuda) {
        this.mesasAyuda = mesasAyuda;
    }
}
