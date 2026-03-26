package br.com.cwi.FinAI.controller.request;

import br.com.cwi.FinAI.domain.Product;
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

    private String status;

    private String aiSummary;

    private LocalDateTime contractedAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
}
