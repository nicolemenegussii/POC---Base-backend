package br.com.cwi.FinAI.mapper;

import br.com.cwi.FinAI.controller.request.CustomerRequest;
import br.com.cwi.FinAI.controller.response.CustomerResponse;
import br.com.cwi.FinAI.domain.Customer;

public class CustomerMapper {
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
    public static Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .name(request.getName())
                .taxId(request.getTaxId())
                .email(request.getEmail())
                .monthlyIncome(request.getMonthlyIncome())
                .creditScore(request.getCreditScore())
                .birthDate(request.getBirthDate())
                .profileDescription(request.getProfileDescription())
                .build();
    }
    public static void editar(Customer entity, CustomerRequest request) {
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setTaxId(request.getTaxId());
        entity.setMonthlyIncome(request.getMonthlyIncome());
        entity.setCreditScore(request.getCreditScore());
        entity.setBirthDate(request.getBirthDate());
        entity.setProfileDescription(request.getProfileDescription());
    }
}
