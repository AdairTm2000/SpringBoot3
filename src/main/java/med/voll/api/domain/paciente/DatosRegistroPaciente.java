package med.voll.api.domain.paciente;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccionPacientes.DatoDireccionPaciente;

public record DatosRegistroPaciente(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @JsonAlias("documento_identidad")
        //@Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String documentoIdentidad,
        @NotBlank
        String telefono,
        @NotNull
        @Valid
        DatoDireccionPaciente direccion) {

}
