package br.com.gestao_de_vagas.modules.company.useCases;

import br.com.gestao_de_vagas.modules.company.entites.JobEntity;
import br.com.gestao_de_vagas.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){
      return this.jobRepository.save(jobEntity);
    }
}
