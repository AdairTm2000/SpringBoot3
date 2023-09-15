package med.voll.api.domain.direccionPacientes;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DatoDireccionPaciente(
        @NotBlank
        String urbanizacion,
        @NotBlank
        String distrito,
        @NotBlank
        @JsonAlias("codigo_postal")
        String codigoPostal,
        @NotBlank
        String complemento,
        @NotBlank
        String numero,
        @NotBlank
        String provincia,
        @NotBlank
        String ciudad) {
}
