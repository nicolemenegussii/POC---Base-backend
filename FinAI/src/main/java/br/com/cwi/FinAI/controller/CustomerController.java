package br.com.cwi.FinAI.controller;

import br.com.cwi.FinAI.controller.request.CustomerRequest;
import br.com.cwi.FinAI.controller.response.CustomerResponse;
import br.com.cwi.FinAI.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cliente/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(CustomerRequest request) {
        customerService.cadastrarCliente(request);
    }

    @PutMapping("{id}/editar")
    @ResponseStatus(HttpStatus.OK)
    public void editarCliente(@PathVariable UUID id, CustomerRequest request) {
        customerService.editarCliente(id, request);
    }

    @GetMapping("{id}/detalhar")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse detalharCliente(@PathVariable UUID id) {
        return customerService.buscarCliente(id);
    }

    @DeleteMapping("{id}/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCliente(@PathVariable UUID id) {
        customerService.deletarCliente(id);
    }
}
