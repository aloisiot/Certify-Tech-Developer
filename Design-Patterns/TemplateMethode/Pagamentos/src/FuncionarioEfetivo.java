public class FuncionarioEfetivo extends Funcionario{
    private double salarioBase;
    private double bonificacao;
    private double desconto;

    public FuncionarioEfetivo(String nome, String sobrenome, String numConta, double salarioBase, double desconto, double bonificacao){
        super(nome, sobrenome, numConta);
        this.salarioBase = salarioBase;
        this.desconto = desconto;
        this.bonificacao = bonificacao;
    }

    @Override
    public double calcularSalario(){
        return salarioBase + bonificacao - desconto;
    }

    @Override
    public void imprimirRecibo(double valor){
        System.out.println("Foi gerado um recibo impresso!");
    }
}
