package br.com.gestao_de_vagas.modules.controller;

import br.com.gestao_de_vagas.modules.candidates.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface  CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
}
