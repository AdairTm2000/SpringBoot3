package med.voll.api.domain.paciente;

import med.voll.api.domain.direccionPacientes.DireccionPaciente;

public record DatosDetalladoPaciente(String nombre, String email, String telefono, String documentoIdentidad, DireccionPaciente direccion) {
    public DatosDetalladoPaciente(Paciente paciente) {
        this(paciente.getNombre(), paciente.getEmail(), paciente.getTelefono(), paciente.getDocumentoIdentidad(), paciente.getDireccion());
    }
}
