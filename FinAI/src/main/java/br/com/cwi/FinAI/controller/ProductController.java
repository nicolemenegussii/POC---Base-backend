package br.com.cwi.FinAI.controller;
import br.com.cwi.FinAI.controller.response.ProductResponse;
import br.com.cwi.FinAI.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> buscarProdutos() {
        return productService.buscarProdutos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse buscarProduto(@PathVariable UUID id) {
        return productService.buscarProduto(id);
    }

}
