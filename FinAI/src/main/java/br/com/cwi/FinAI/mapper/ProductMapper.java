package br.com.cwi.FinAI.mapper;

import br.com.cwi.FinAI.controller.request.ProductRequest;
import br.com.cwi.FinAI.controller.response.ProductResponse;
import br.com.cwi.FinAI.domain.Product;

public class ProductMapper {
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

    public static Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .category(request.getCategory())
                .technicalDescription(request.getTechnicalDescription())
                .humanizedDescription(request.getHumanizedDescription())
                .targetProfile(request.getTargetProfile())
                .rules(request.getRules())
                .rates(request.getRates())
                .build();
    }

    public static void editar(Product entity, ProductRequest request) {
        entity.setName(request.getName());
        entity.setCategory(request.getCategory());
        entity.setTechnicalDescription(request.getTechnicalDescription());
        entity.setHumanizedDescription(request.getHumanizedDescription());
        entity.setTargetProfile(request.getTargetProfile());
        entity.setRules(request.getRules());
        entity.setRates(request.getRates());
    }
}
