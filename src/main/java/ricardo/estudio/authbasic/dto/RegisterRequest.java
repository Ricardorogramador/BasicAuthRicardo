package ricardo.estudio.authbasic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Can not be empty")
    private String name;
    @NotBlank(message = "Can not be empty") @Email(message = "Introduce a correct format")
    private String email;
    @NotBlank(message = "Can not be empty") @Size(min = 7, message = "Password must be at least 7 letters")
    private String password;
}
