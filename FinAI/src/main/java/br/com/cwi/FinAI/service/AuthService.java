package br.com.cwi.FinAI.service;

import br.com.cwi.FinAI.domain.Customer;
import br.com.cwi.FinAI.dto.request.LoginRequest;
import br.com.cwi.FinAI.dto.request.RegisterRequest;
import br.com.cwi.FinAI.dto.response.CustomerResponse;
import br.com.cwi.FinAI.dto.response.LoginResponse;
import br.com.cwi.FinAI.mapper.CustomerResponseMapper;
import br.com.cwi.FinAI.repository.CustomerRepository;
import br.com.cwi.FinAI.validator.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthService{

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;
    private final CustomerValidator customerValidator;

    @Value("${jwt.expiration-seconds:600}")
    private long expirationSeconds;

    public LoginResponse authenticate(LoginRequest request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPasswordHash())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        return LoginResponse.builder()
                .accessToken(generateToken(customer))
                .expiresIn(expirationSeconds)
                .build();
    }

    public CustomerResponse register(RegisterRequest request) {
        customerValidator.validateNewCustomer(request);

        Customer customer = Customer.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .monthlyIncome(BigDecimal.valueOf(request.getMonthlyIncome()))
                .birthDate(request.getBirthDate())
                .build();

        customerRepository.save(customer);

        return CustomerResponseMapper.toResponse(customer);
    }

    private String generateToken(Customer customer) {
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("fin-ai")
                .subject(customer.getId().toString())
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(expirationSeconds))
                .claim("email", customer.getEmail())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}