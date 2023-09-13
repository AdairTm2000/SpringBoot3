package med.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatoDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad,
        @NotBlank
        String numero,
        @NotBlank
        String complemento) {
}
