package br.com.cwi.FinAI.controller.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private UUID id;

    private String name;

    private String taxId;

    private String email;

    private BigDecimal monthlyIncome;

    private Integer creditScore;

    private LocalDate birthDate;

    private String profileDescription;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();


}
