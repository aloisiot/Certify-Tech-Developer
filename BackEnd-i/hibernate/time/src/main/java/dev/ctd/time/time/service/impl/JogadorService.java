package dev.ctd.time.time.service.impl;

import dev.ctd.time.time.model.Jogador;
import dev.ctd.time.time.reposytory.JogadorRepository;
import dev.ctd.time.time.reposytory.TreinadorRepository;
import dev.ctd.time.time.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JogadorService implements IService <Jogador>{

    private JogadorRepository jogadorRepository;
    private TreinadorRepository treinadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository, TreinadorRepository treinadorRepository) {
        this.jogadorRepository = jogadorRepository;
        this.treinadorRepository = treinadorRepository;
    }

    @Override
    public Map cadastrar(Map jogadorMap) {

        Jogador jogador = new Jogador();

        jogador.setNome((String) jogadorMap.get("nome"));
        jogador.setTimeFavorito((String) jogadorMap.get("timeFavorito"));
        jogador.setTreinador(treinadorRepository.getById((long) jogadorMap.get("idTreinador")));

        jogador = jogadorRepository.save(jogador);
        jogadorMap.put("id", jogador.getId());

        return jogador.getId() != null ? jogadorMap : null;
    }

    @Override
    public List<Map> buscarTodos() {
        List<Jogador> jogadores = jogadorRepository.findAll();
        return objectListToMapList(jogadores);
    }

    @Override
    public Map buscarPorNome(String nome) {
        return objectToMap(jogadorRepository.findByNome(nome).get());
    }

    @Override
    public List<Map> buscarCujoNomeContem(String subString) {
        List<Jogador> jogadores = jogadorRepository.findByNomeContaining(subString);
        return objectListToMapList(jogadores);
    }

    public List<Map> buscarPorTreinador(Long idTreinador){
        List<Jogador> jogadores = treinadorRepository.findById(idTreinador).get().getJogadores();
        return objectListToMapList(jogadores);
    }

    @Override
    public Map objectToMap(Jogador jogador) {
        Map<String, Object> jMap = new HashMap<>();

        jMap.put("id", jogador.getId());
        jMap.put("nome", jogador.getNome());
        jMap.put("timeFavorito", jogador.getTimeFavorito());

        if (jogador.getTreinador() != null)
            jMap.put("idTreinador", Long.toString(jogador.getTreinador().getId()));

        return jMap;
    }

    @Override
    public List<Map> objectListToMapList(List<Jogador> jogadores) {
        if(jogadores == null)
            return null;

        List<Map> result = new ArrayList<>();
        for(Jogador j : jogadores)
            result.add(objectToMap(j));
        return result;
    }

}
