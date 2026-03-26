package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.dto.request.ContractRequest;
import br.com.cwi.FinAI.dto.response.ContractResponse;
import br.com.cwi.FinAI.domain.Contract;
import br.com.cwi.FinAI.domain.Customer;
import br.com.cwi.FinAI.domain.Product;
import br.com.cwi.FinAI.mapper.ContractResponseMapper;
import br.com.cwi.FinAI.repository.ContractRepository;
import br.com.cwi.FinAI.repository.CustomerRepository;
import br.com.cwi.FinAI.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public ContractService(ContractRepository contractRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.contractRepository = contractRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<ContractResponse> buscarContratos() {
        return contractRepository.findAll().stream().map(contract -> ContractResponseMapper.toResponse(contract))
                .collect(Collectors
                        .toList());
    }

    public ContractResponse detalharContrato(UUID id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nenhum contrato encontrado com esse Id."));
        return ContractResponseMapper.toResponse(contract);
    }

    public void criarContrato(ContractRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer não encontrado"
                ));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product não encontrado"
                ));
        Contract contract = ContractResponseMapper.toEntity(request, customer, product);
        contractRepository.save(contract);
    }


}
