package med.voll.api.domain.paciente;

public record DatoListadoPaciente(Long id, String nombre, String email, String documentoIdentidad) {

    public DatoListadoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumentoIdentidad());
    }
}
