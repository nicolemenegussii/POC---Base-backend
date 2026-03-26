package br.com.cwi.FinAI.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private String accessToken;
    private Long expiresIn;
}
