package ar.dev.maxisandoval.footballapieditjwt.service;

import ar.dev.maxisandoval.footballapieditjwt.entity.Role;
import ar.dev.maxisandoval.footballapieditjwt.entity.User;
import ar.dev.maxisandoval.footballapieditjwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("El usuario ya se encuentra registrado!");
        }

        User user = User.builder()
                        .username(username)
                        .password(passwordEncoder.encode(password))
                        .role(Role.USER)
                        .build();

        userRepository.save(user);
        return jwtService.generateToken(user);
    }

    public String authenticate(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Usuario o contraseña incorrecto");
        }

        return jwtService.generateToken(user);
    }
}
