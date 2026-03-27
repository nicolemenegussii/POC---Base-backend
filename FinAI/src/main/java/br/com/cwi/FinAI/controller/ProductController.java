package br.com.cwi.FinAI.controller;
import br.com.cwi.FinAI.controller.request.ProductRequest;
import br.com.cwi.FinAI.controller.response.ProductResponse;
import br.com.cwi.FinAI.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> buscarProdutos() {
        return productService.buscarProdutos();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse buscarProduto(@PathVariable UUID id) {
        return productService.buscarProduto(id);
    }

    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse cadastrarProduto(ProductRequest request) {
        return productService.cadastrar(request);
    }

    @PutMapping("{id}/editar")
    @ResponseStatus(HttpStatus.OK)
    public void editarProduto(@PathVariable UUID id, ProductRequest request) {
        productService.editarProduto(id, request);
    }

    @DeleteMapping("{id}/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProduto(@PathVariable UUID id) {
        productService.deletar(id);
    }

    @GetMapping("buscarPorIntencao")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> buscarPorIntencao(String intencao) {
        return productService.buscarPorIntencao(intencao);
    }

}
