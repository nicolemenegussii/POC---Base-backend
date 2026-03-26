package br.com.cwi.FinAI.repository;

import br.com.cwi.FinAI.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
