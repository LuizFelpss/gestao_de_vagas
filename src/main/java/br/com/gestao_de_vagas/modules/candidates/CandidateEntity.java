package br.com.gestao_de_vagas.modules.candidates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;


import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name ="Candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @NotBlank
    @Pattern(regexp = "(?!//s*$).+", message = "O campo username não deve conter espaço")
    private String username;

    @Email(message = "o campo deve conter um e-mail valido!")
    private String email;

    @Length(min = 10, max = 100)
    private String password;

    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
