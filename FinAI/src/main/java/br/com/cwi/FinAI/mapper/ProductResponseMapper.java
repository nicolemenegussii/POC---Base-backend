package br.com.cwi.FinAI.mapper;

import br.com.cwi.FinAI.controller.response.ProductResponse;
import br.com.cwi.FinAI.domain.Product;

public class ProductResponseMapper {
    public static ProductResponse toResponse(Product entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .rates(entity.getRates())
                .rules(entity.getRules())
                .active(entity.getActive())
                .category(entity.getCategory())
                .createdAt(entity.getCreatedAt())
                .targetProfile(entity.getTargetProfile())
                .humanizedDescription(entity.getHumanizedDescription())
                .technicalDescription(entity.getTechnicalDescription())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
