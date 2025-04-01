package br.com.gestao_de_vagas.modules.controller;

import br.com.gestao_de_vagas.modules.candidates.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface  CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    //Quando utilizo o FindBy, o jpa faz um select no banco...
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
