package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsultas;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository respository;

    public void validar(DatosAgendarConsultas datos) {
        if(datos.id_paciente() == null) {
            return;
        }

        var pacienteActivo = respository.findActivoById(datos.id_paciente());

        if(!pacienteActivo) {
            throw new ValidationException("No se puede permitir agendar citas con pacientes inactivos en el sistema");
        }

    }
}
