package med.voll.api.domain.direccionPacientes;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable //se indica que puede ser integrado en una entidad
@Getter //Genera getters y setters automaticamente
@NoArgsConstructor //Contructor default sin atributos
@AllArgsConstructor //Constructor con atributos
public class DireccionPaciente {
    private String urbanizacion;
    private String distrito;
    private String codigoPostal;
    private String complemento;
    private String numero;
    private String provincia;
    private String ciudad;

    public DireccionPaciente(DatoDireccionPaciente direccion) {
        this.urbanizacion = direccion.urbanizacion();
        this.distrito = direccion.distrito();
        this.codigoPostal = direccion.codigoPostal();
        this.complemento = direccion.complemento();
        this.numero = direccion.numero();
        this.provincia = direccion.provincia();
        this.ciudad = direccion.ciudad();
    }

    public DireccionPaciente atualizarInfo(DatoDireccionPaciente direccion) {
        this.urbanizacion = direccion.urbanizacion();
        this.distrito = direccion.distrito();
        this.codigoPostal = direccion.codigoPostal();
        this.complemento = direccion.complemento();
        this.numero = direccion.numero();
        this.provincia = direccion.provincia();
        this.ciudad = direccion.ciudad();
        return this;
    }
}
