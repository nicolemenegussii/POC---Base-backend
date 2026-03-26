package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.domain.Customer;
import br.com.cwi.FinAI.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Service
@RequiredArgsConstructor
public class CustomerAuthService {

    private final CustomerRepository customerRepository;

    public Customer getAuthenticatedCustomer() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext()
                .getAuthentication().getCredentials();
        String email = jwt.getClaim("email");
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(UNAUTHORIZED,
                        "Authenticated customer not found"));
    }
}
