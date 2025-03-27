package br.com.gestao_de_vagas.modules.controller;

import br.com.gestao_de_vagas.modules.candidates.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create(@Valid @RequestBody CandidateEntity candidateEntity){
        System.out.println("Candidato:");
        System.out.println(candidateEntity.getNome());
    }

}
