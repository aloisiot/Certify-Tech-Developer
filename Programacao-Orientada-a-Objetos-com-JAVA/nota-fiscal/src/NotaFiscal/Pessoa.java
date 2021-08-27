package NotaFiscal;

public abstract class Pessoa {
    private int cpfCnpj;
    private String nome;

    public Pessoa(int cpfCnpj, String nome) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
    }

    public int getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(int cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
