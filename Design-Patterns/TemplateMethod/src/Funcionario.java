public abstract class Funcionario {
    private String nome;
    private String sobrenome;
    private String numConta;

    public Funcionario(String nome, String sobrenome, String numConta){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numConta = numConta;
    }

    public void pagamentoSalario(){
        double valor = calcularSalario();
        depositar(valor);
        imprimirRecibo(valor);
    }

    public void depositar(double valor){
        System.out.printf("Foi depositada a quantia de %.2f na conta %s", valor, getNumConta());
    }

    public abstract double calcularSalario();

    public abstract void imprimirRecibo(double valor);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }
}