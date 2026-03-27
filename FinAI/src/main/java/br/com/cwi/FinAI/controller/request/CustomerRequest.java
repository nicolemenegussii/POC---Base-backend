package br.com.cwi.FinAI.controller.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CustomerRequest {
    @NotBlank
    private String name;


    @NotBlank
    private String taxId;

    @NotBlank
    @Email(message = "Email inválido")
    private String email;

    @NotNull
    @Positive
    private BigDecimal monthlyIncome;

    @NotNull
    @Min(0)
    @Max(1000)
    private Integer creditScore;

    @NotNull
    private LocalDate birthDate;

    @NotBlank
    private String profileDescription;
}
