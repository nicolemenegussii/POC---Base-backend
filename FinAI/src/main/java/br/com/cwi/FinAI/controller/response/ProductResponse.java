package br.com.cwi.FinAI.controller.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {
    private UUID id;

    private String name;

    private String category;

    private String technicalDescription;

    private String humanizedDescription;

    private String targetProfile;

    private String rules;

    private String rates;

    private Boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
}
