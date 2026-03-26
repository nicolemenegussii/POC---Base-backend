package br.com.cwi.FinAI.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos")
    @CPF(message = "O CPF precisa se válido")
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, message = "A senha deve possuir 8 caracteres ou mais")
    private String password;

    @NotNull
    private Double monthlyIncome;

    @NotNull
    private LocalDate birthDate;
}
