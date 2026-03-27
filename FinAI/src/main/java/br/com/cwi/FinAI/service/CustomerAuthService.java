package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.domain.Customer;
import br.com.cwi.FinAI.dto.response.CustomerResponse;
import br.com.cwi.FinAI.mapper.CustomerResponseMapper;
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

    public CustomerResponse getAuthenticatedCustomer() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext()
                .getAuthentication().getCredentials();
        String email = jwt.getClaim("email");
        return CustomerResponseMapper.toResponse(
                customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(UNAUTHORIZED, "Usuário autenticado não foi encontrado")));
    }
}
