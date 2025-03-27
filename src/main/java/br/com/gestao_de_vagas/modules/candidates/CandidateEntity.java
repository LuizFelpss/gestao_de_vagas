package br.com.gestao_de_vagas.modules.candidates;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {
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
}
