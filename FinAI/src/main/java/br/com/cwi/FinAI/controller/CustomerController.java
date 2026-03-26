package br.com.cwi.FinAI.controller;

import br.com.cwi.FinAI.controller.response.CustomerResponse;
import br.com.cwi.FinAI.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse detalharCliente(@PathVariable UUID id) {
        return customerService.buscarCliente(id);
    }
}
