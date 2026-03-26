package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.dto.response.ProductResponse;
import br.com.cwi.FinAI.domain.Product;
import br.com.cwi.FinAI.mapper.ProductResponseMapper;
import br.com.cwi.FinAI.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> buscarProdutos() {
        return productRepository.findAll().stream().map(product -> ProductResponseMapper.toResponse(product))
                .collect(Collectors
                        .toList());
    }

    public ProductResponse buscarProduto(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto encontrado com este Id"));
        return ProductResponseMapper.toResponse(product);
    }

}
