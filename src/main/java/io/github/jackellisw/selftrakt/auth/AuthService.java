package io.github.jackellisw.selftrakt.auth;


import io.github.jackellisw.selftrakt.auth.dto.LoginRequest;
import io.github.jackellisw.selftrakt.auth.dto.LoginResponse;
import io.github.jackellisw.selftrakt.user.UserEntity;
import io.github.jackellisw.selftrakt.user.UserRepository;
import io.github.jackellisw.selftrakt.user.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity user =  userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
            throw new UserNotFoundException("Wrong password!");
        }

        String token = generateToken(user);
        return new LoginResponse(token);
    }

    private String generateToken(UserEntity user) {

        throw new UnsupportedOperationException("JWT generation failed");
    }
}
