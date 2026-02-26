package io.github.jackellisw.selftrakt.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;

    @Column(name="email", unique = true)
    String email;

    @Column(name="password_hash")
    String passwordHash;

    Instant createdAt;

    public UserEntity() {
    }

    public UserEntity(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = Instant.now();
    }
}
