package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.controller.response.CustomerResponse;
import br.com.cwi.FinAI.domain.Customer;
import br.com.cwi.FinAI.mapper.CustomerResponseMapper;
import br.com.cwi.FinAI.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerReposity) {
        this.customerRepository = customerReposity;
    }

    public CustomerResponse buscarCliente(UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nenhum cliente encontrado com esse Id."));
        return CustomerResponseMapper.toResponse(customer);
    }

}
