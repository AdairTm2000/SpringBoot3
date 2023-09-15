package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validaciones.ValidadorDeConsultas;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    List<ValidadorDeConsultas> validadores;

    public DatosDetalleConsulta agendar(DatosAgendarConsultas datos) {

        if (!pacienteRepository.findById(datos.id_paciente()).isPresent()) {
            throw new ValidacionDeIntegridad("este id para el paciente no fue encontrado");
        }

        if (datos.id_medico() != null && !medicoRepository.existsById(datos.id_medico())) {
            throw new ValidacionDeIntegridad("este id para el medico no fue encontrado");
        }

        //validaciones

        validadores.forEach(v -> v.validar(datos));

        var paciente = pacienteRepository.findById(datos.id_paciente()).get();
        var medico = seleccionarmedico(datos);

        if (medico == null) {
            throw new ValidacionDeIntegridad("no existe medicos disponibles para este horario y especialidad");
        }

        var consulta = new Consulta(null, medico, paciente, datos.fecha());

        consultaRepository.save(consulta);

        return new DatosDetalleConsulta(consulta);
    }

    private Medico seleccionarmedico(DatosAgendarConsultas datos) {
        if(datos.id_medico() != null) {
            return medicoRepository.getReferenceById(datos.id_medico());
        }
        if(datos.especialidad() == null) {
            throw new ValidacionDeIntegridad("debe seleccionarse una especialidad para el medico");
        }

        return medicoRepository.seleccionarMedicoConEspecilidadEnFecha(datos.especialidad(), datos.fecha());
    }

}
