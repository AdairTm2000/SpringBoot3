package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatoDireccion;

public record DtosRegistroMedico(
        @NotBlank(message = "{nombre.obligatorio}")
        String nombre,
        @NotBlank(message = "{email.obligatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{phone.obligatorio}")
        String telefono,
        @NotBlank(message = "{crm.obligatorio}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}") //Solo numeros de 4 a 6 digitos
        String documento,
        @NotNull(message = "{especialidad.obligatorio}")
        Especialidad especialidad,
        @NotNull(message = "{address.obligatorio}")
        @Valid
        DatoDireccion direccion) {

}
