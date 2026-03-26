package br.com.cwi.FinAI.controller;

import br.com.cwi.FinAI.controller.request.ContractRequest;
import br.com.cwi.FinAI.controller.response.ContractResponse;
import br.com.cwi.FinAI.domain.Contract;
import br.com.cwi.FinAI.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContractResponse> buscarContratos() {
        return contractService.buscarContratos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContractResponse detalharContrato(@PathVariable UUID id) {
        return contractService.detalharContrato(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void criarContrato(@RequestBody ContractRequest contract) {
        contractService.criarContrato(contract);
    }

}
