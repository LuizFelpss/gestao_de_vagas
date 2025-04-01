package br.com.gestao_de_vagas.modules.controller;

import br.com.gestao_de_vagas.modules.candidates.CandidateEntity;
import br.com.gestao_de_vagas.modules.candidates.useCases.CreateCandidateEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateEntity createCandidateEntity;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try{
            var result = createCandidateEntity.execute(candidateEntity);
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}


