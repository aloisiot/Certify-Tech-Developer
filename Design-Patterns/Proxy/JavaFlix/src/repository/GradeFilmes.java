package repository;

import models.Cliente;
import models.Filme;
import models.IGradeFilme;

import java.util.ArrayList;
import java.util.List;

public class GradeFilmes implements IGradeFilme {
    private final List<Filme> filmes = new ArrayList<>();
    private static GradeFilmes grade;

    private GradeFilmes(){}

    @Override
    public Filme getFilme(Cliente cliente, String nomeFilme){
        System.out.printf("%nFilme solicitado: %s%nCliente: %s%nIP: %s%n",nomeFilme, cliente.getNome(), cliente.getIp());
        for (Filme f : filmes) {
            if(f.getNome().equalsIgnoreCase(nomeFilme)) return f;
        }
        return null;
    }

    // Singletom pattern
    public static GradeFilmes getInstance(){
        if(grade == null) grade = new GradeFilmes();
        return grade;
    }

    public void addFilme(Filme filme){
        if(filme != null) this.filmes.add(filme);
    }
}
