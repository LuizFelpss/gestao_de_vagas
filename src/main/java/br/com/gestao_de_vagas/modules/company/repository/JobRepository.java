package br.com.gestao_de_vagas.modules.company.repository;

import br.com.gestao_de_vagas.modules.company.entites.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository  extends JpaRepository<JobEntity, UUID> {
}
