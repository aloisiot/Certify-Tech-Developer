package dev.digitalhouse.testeintegracao.service;

import dev.digitalhouse.testeintegracao.model.Jogador;
import dev.digitalhouse.testeintegracao.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Optional<Jogador> findByNome(String nome){
        return jogadorRepository.findByNome(nome);
    }
}
