package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsultas;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository respository;

    public void validar(DatosAgendarConsultas datos) {
        if(datos.id_medico() == null) {
            return;
        }

        var medicoActivo = respository.findActivoById(datos.id_medico());

        if(!medicoActivo) {
            throw new ValidationException("No se puede permitir agendar citas con medicos inactivos en el sistema");
        }

    }
}
