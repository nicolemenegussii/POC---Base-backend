package br.com.cwi.FinAI.dto.response;

import br.com.cwi.FinAI.domain.enums.ContractStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractResponse {
    private UUID id;

    private UUID customerID;
    private String customerName;

    private UUID productID;
    private String productName;

    private String contractData;

    private ContractStatus status;

    private String aiSummary;

    private LocalDateTime contractedAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
}
