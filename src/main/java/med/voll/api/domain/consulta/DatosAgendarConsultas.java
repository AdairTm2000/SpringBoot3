package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosAgendarConsultas(Long id, @NotNull Long id_paciente, Long id_medico, @NotNull @Future LocalDateTime fecha, Especialidad especialidad) {
}
