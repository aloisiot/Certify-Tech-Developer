public class App {
    public static void main(String[] args){
        Funcionario funcionario = new FuncionarioContratado(
                "Aloisio",
                "Carvalho",
                "2344",
                100.00,
                40
        );

        funcionario.pagamentoSalario();
    }
}
