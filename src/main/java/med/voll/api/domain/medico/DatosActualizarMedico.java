package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatoDireccion;

public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, DatoDireccion direccion) {
}
