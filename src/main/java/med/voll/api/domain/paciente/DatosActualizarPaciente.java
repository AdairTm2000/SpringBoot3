package med.voll.api.domain.paciente;

import med.voll.api.domain.direccionPacientes.DatoDireccionPaciente;

public record DatosActualizarPaciente(Long id, String nombre, String telefono, DatoDireccionPaciente direccion) {
}
