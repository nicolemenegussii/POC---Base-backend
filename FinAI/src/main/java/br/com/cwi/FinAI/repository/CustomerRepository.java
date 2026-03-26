package br.com.cwi.FinAI.repository;

import br.com.cwi.FinAI.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
