package br.com.cwi.FinAI.mapper;

import br.com.cwi.FinAI.controller.response.CustomerResponse;
import br.com.cwi.FinAI.domain.Customer;

public class CustomerResponseMapper {
    public static CustomerResponse toResponse(Customer entity) {
        return CustomerResponse.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .taxId(entity.getTaxId())
                .birthDate(entity.getBirthDate())
                .createdAt(entity.getCreatedAt())
                .creditScore(entity.getCreditScore())
                .monthlyIncome(entity.getMonthlyIncome())
                .profileDescription(entity.getProfileDescription())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
