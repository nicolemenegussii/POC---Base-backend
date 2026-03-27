package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.controller.request.CustomerRequest;
import br.com.cwi.FinAI.controller.response.CustomerResponse;
import br.com.cwi.FinAI.domain.Customer;
import br.com.cwi.FinAI.mapper.CustomerMapper;
import br.com.cwi.FinAI.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerReposity) {
        this.customerRepository = customerReposity;
    }

    public void cadastrarCliente(CustomerRequest request) {
        Customer customer = CustomerMapper.toEntity(request);
        customerRepository.save(customer);
    }

    public void editarCliente(UUID id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        CustomerMapper.editar(customer, request);
        customerRepository.save(customer);
    }

    public CustomerResponse buscarCliente(UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nenhum cliente encontrado com esse Id."));
        return CustomerMapper.toResponse(customer);
    }

    public void deletarCliente(UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nenhum cliente encontrado com esse Id."));
        customerRepository.delete(customer);
    }

}
