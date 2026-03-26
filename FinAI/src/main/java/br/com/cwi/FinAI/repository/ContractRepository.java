package br.com.cwi.FinAI.repository;

import br.com.cwi.FinAI.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {
}
