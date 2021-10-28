package service;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void addPessoa(Pessoa pessoa){
        if(pessoa != null && pessoa.eAdulto()){
            pessoas.add(pessoa);
        }
    }

    public int numPessoas(){
        return pessoas.size();
    }
}
