package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosAgendarConsultas datos) {

        if(datos.id_medico() == null) {
            return;
        }

        var medicoConConsulta = repository.existsByMedicoIdAndFecha(datos.id_medico(), datos.fecha());

        if(medicoConConsulta) {
            throw new ValidationException("Este medico ya tiene una consulta en ese horario");
        }

    }
}
