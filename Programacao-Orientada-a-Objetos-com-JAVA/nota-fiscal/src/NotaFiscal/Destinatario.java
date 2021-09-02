package NotaFiscal;

public class Destinatario extends Pessoa {
    private Endereco endereco;
    private int inscricaoEstadual;
    private String telefone;

    public Destinatario(String nome,  Endereco endereco, int inscricaoEstadual, String telefone, int cpfCnpj) {
        super(cpfCnpj ,nome);
        this.endereco = endereco;
        this.inscricaoEstadual = inscricaoEstadual;
        this.telefone = telefone;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
