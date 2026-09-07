package ar.dev.maxisandoval.footballapieditjwt.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
}