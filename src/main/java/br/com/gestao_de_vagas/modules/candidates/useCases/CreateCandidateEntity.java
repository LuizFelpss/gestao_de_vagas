package br.com.gestao_de_vagas.modules.candidates.useCases;

import br.com.gestao_de_vagas.modules.candidates.CandidateEntity;
import br.com.gestao_de_vagas.modules.controller.CandidateRepository;
import br.com.gestao_de_vagas.modules.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateEntity {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
                candidateEntity.getEmail()).ifPresent(user -> {
            throw new UserFoundException();
        });

        return this.candidateRepository.save(candidateEntity);
    }
}
