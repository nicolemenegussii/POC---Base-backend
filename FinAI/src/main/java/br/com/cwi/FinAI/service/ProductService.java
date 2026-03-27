package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.controller.request.ProductRequest;
import br.com.cwi.FinAI.controller.response.ProductResponse;
import br.com.cwi.FinAI.domain.Product;
import br.com.cwi.FinAI.mapper.ProductMapper;
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

    public ProductResponse cadastrar(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        productRepository.save(product);
        return ProductMapper.toResponse(product);
    }

    public List<ProductResponse> buscarProdutos() {
        return productRepository.findAll().stream().map(product -> ProductMapper.toResponse(product))
                .collect(Collectors
                        .toList());
    }

    public ProductResponse buscarProduto(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto encontrado com este Id"));
        return ProductMapper.toResponse(product);
    }

    public void editarProduto(UUID id, ProductRequest request) {
        Product  product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        ProductMapper.editar(product, request);
        productRepository.save(product);
    }

    public void deletar(UUID id) {
        Product  product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        productRepository.delete(product);
    }

    public List<ProductResponse> buscarPorIntencao(String category) {
        return productRepository.findByCategory(category).stream().map(product -> ProductMapper.toResponse(product))
                .collect(Collectors
                        .toList());
    }
}
