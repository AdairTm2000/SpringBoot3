package med.voll.api.domain.medico;

public record DatodListadoMedico(Long id, String nombre, String especialidad, String documento, String email) {

    public DatodListadoMedico(Medico medico) {
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }

}
