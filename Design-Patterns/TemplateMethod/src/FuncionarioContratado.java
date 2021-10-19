public class FuncionarioContratado extends Funcionario{
    private double valorHora;
    private int horas;

    public FuncionarioContratado(String nome, String sobrenome, String numConta, double valorHora, int horas){
        super(nome, sobrenome, numConta);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    @Override
    public double calcularSalario(){
        return valorHora * horas;
    }

    @Override
    public void imprimirRecibo(double valor){
        System.out.println("Foi gerado um recibo digital!");
    }
}
