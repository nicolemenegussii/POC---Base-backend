package br.com.cwi.FinAI.dto.request;

import br.com.cwi.FinAI.domain.enums.ContractStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ContractRequest {

    private UUID customerId;

    private UUID productId;

    private String contractData;

    private ContractStatus status;

    private String aiSummary;

    private LocalDateTime contractedAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
}
