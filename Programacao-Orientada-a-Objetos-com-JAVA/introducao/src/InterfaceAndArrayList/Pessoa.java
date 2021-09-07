package InterfaceAndArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pessoa {

    private String nome;
    private String sobreNome;
    private int idade;
    private List<Conta> contas = new ArrayList<>();

    public Pessoa(String nome, String sobreNome, int idade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
    }

    // Cria e adciona uma nova conta para Pessoa
    public void novaConta(int num, double saldo){
        Conta c = new Conta(num, saldo);
        this.contas.add(c);
    }

    // Retorna o nome completo de Pessoa
    public String getNomeCompleto(){
        return this.nome + " " + this.sobreNome;
    }

    // Verifica se Pessoa tem mais de 18 anos
    public boolean maiorDeIdade(){
        return idade <= 18;
    }

    // Retorna o saldo total somando todas as contas de Pessoa
    public double getSaldoTotal(){
        double saldo = 0;

        for(int i =0; i < this.contas.size(); i++){
            saldo += this.contas.get(i).getSaldo();
        }

        return saldo;
    }

    // Retorna as informações de cada conta ordanando-as pelo saldo na decrescente
    public String mostrarContas(){
        String result = "";
        List<Conta> c = this.contas;
        Collections.sort(c, Conta::compareTo);

        for(int i = 0; i < c.size(); i++){
            result += "\nConta: " + c.get(i).getNum() + " Saldo: " + c.get(i).getSaldo();
        }
        return result + "\n";
    }

}
