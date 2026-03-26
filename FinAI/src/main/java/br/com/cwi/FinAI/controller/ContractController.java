package br.com.cwi.FinAI.controller;

import br.com.cwi.FinAI.dto.request.ContractRequest;
import br.com.cwi.FinAI.dto.response.ContractResponse;
import br.com.cwi.FinAI.service.ContractService;
import org.springframework.http.HttpStatus;
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
