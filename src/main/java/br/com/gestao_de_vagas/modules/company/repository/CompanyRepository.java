package br.com.gestao_de_vagas.modules.company.repository;

import br.com.gestao_de_vagas.modules.company.entites.CompanyEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUsernameOrEmail(@NotBlank @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço") String username, @Email(message = "O campo [email] deve conter um e-mail válido") String email);
}
