package dev.escola.escola.service;

import dev.escola.escola.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController("/estudante")
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @GetMapping("/{id}")
    private ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(estudanteRepository.findById(id));
    }
}
