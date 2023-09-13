package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(Long id, Long id_paciente, Long id_medico, LocalDateTime fecha) {
}
