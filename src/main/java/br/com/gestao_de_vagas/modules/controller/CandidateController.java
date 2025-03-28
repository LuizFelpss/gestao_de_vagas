package br.com.gestao_de_vagas.modules.controller;

import br.com.gestao_de_vagas.modules.candidates.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity){
        return this.candidateRepository.save(candidateEntity);
    }

}
