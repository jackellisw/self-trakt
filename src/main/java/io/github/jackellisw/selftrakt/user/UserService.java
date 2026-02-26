package io.github.jackellisw.selftrakt.user;

import io.github.jackellisw.selftrakt.user.dto.RegisterUserRequest;
import io.github.jackellisw.selftrakt.user.dto.RegisterUserResponse;
import io.github.jackellisw.selftrakt.user.exception.UserAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public RegisterUserResponse register(RegisterUserRequest request) {
        String normalizedEmail = request.getEmail().toLowerCase().trim();

        if (userRepository.findByEmail(normalizedEmail).isPresent()) {
            throw new UserAlreadyExistsException("User already exists!");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        UserEntity user = new UserEntity(normalizedEmail, hashedPassword);
        UserEntity saved = userRepository.save(user);

        return new RegisterUserResponse(saved.getId(), saved.getEmail());
    }





}
