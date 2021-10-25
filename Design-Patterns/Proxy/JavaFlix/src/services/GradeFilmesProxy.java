package services;

import models.Cliente;
import models.Filme;
import models.IGradeFilme;
import repository.GradeFilmes;
import throwables.FilmeNaoHabilitadoException;

public class GradeFilmesProxy implements IGradeFilme {
    @Override
    public Filme getFilme(Cliente cliente, String nomeFilme) throws FilmeNaoHabilitadoException {
        GradeFilmes grade = GradeFilmes.getInstance();
        Filme filme = grade.getFilme(cliente, nomeFilme);

        if(filme == null || !checkCliente(cliente, filme)){
            String mensagemErro = String.format("%nO filme %s não está disponivel!", nomeFilme);
            throw new FilmeNaoHabilitadoException(mensagemErro);
        }
        return filme;
    }

    private String definePaisCliente(Cliente cliente) {
        String pais = null;
        int ipLocalizacao = Integer.valueOf(cliente.getIp().split("\\.")[0]);

        if(0 <= ipLocalizacao && ipLocalizacao < 50 ) pais = "Argentina";
        if(50 <= ipLocalizacao && ipLocalizacao < 100 ) pais = "Brasil";
        if(100 <= ipLocalizacao && ipLocalizacao < 150 ) pais = "Colombia";
        return pais;
    }

    private boolean checkCliente(Cliente cliente, Filme filme){
        String paisCliente = definePaisCliente(cliente);
        return paisCliente.equalsIgnoreCase(filme.getPais());
    }
}
