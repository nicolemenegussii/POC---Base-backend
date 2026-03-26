package br.com.cwi.FinAI.mapper;

import br.com.cwi.FinAI.controller.request.ContractRequest;
import br.com.cwi.FinAI.controller.response.ContractResponse;
import br.com.cwi.FinAI.domain.Contract;
import br.com.cwi.FinAI.domain.Customer;
import br.com.cwi.FinAI.domain.Product;


public class ContractResponseMapper {
    public static ContractResponse toResponse(Contract entity) {
        return ContractResponse.builder()
                .id(entity.getId())
                .contractedAt(entity.getContractedAt())
                .status(entity.getStatus())
                .productID(entity.getProduct().getId())
                .productName(entity.getProduct().getName())
                .contractData(entity.getContractData())
                .customerID(entity.getCustomer().getId())
                .customerName(entity.getCustomer().getName())
                .aiSummary(entity.getAiSummary())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static Contract toEntity(ContractRequest request, Customer customer, Product product) {
        return Contract.builder()
                .contractedAt(request.getContractedAt())
                .status(request.getStatus())
                .product(product)
                .contractData(request.getContractData())
                .customer(customer)
                .aiSummary(request.getAiSummary())
                .updatedAt(request.getUpdatedAt())
                .build();
    }
}
