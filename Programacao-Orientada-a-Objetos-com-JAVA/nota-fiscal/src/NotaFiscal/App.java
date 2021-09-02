package NotaFiscal;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        Endereco enderecoDestinatario = new Endereco("Rua das Flores", 50, "Centro","Cidade Nova" , "MG");

        Endereco enderecoEmitente = new Endereco("Rua Machado de Acis", 300, "Centro","Sao Jose" , "SP");

        Destinatario destinatario = new Destinatario("Mercadinho do João", enderecoDestinatario, 123, "(54) 85642-569", 1253654859);

        Transportador transportador = new Transportador("Leva e Traz", "HNR3265", 16729);

        Emitente emitente = new Emitente(123446567, "Distribuidora Legal", enderecoEmitente, 657378, "(35) 1526-74546");

        Produto produto = new Produto(3000.00, 120, 20, "12/10/2025", "12/10/2020");

        NotaFiscal notaFiscal = new NotaFiscal(destinatario, emitente,transportador, 45463548, new Date(), produto);

        notaFiscal.printNotaFiscal();
    }
}
