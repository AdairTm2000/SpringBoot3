package med.voll.api.domain.direccionPacientes;

import jakarta.validation.constraints.NotBlank;

public record DatoDireccionPaciente(
        @NotBlank
        String urbanizacion,
        @NotBlank
        String distrito,
        @NotBlank
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
