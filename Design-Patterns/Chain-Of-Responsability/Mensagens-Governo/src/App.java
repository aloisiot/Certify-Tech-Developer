import models.Deputado;
import models.Mensagem;
import models.Ministro;
import models.Presidente;

public class App {
    public static void main(String[] args) {
        Mensagem mensagem1 = new Mensagem("Mensagem reservada", 1);
        Mensagem mensagem2= new Mensagem("Mensagem secreta", 2);
        Mensagem mensagem3 = new Mensagem("Mensagem muito secreta", 3);

        Presidente presidente = new Presidente(3, "Presidente");

        Ministro ministro = new Ministro(2, "Ministro");
        ministro.setProximoMembro(presidente);

        Deputado deputado = new Deputado(1, "Deputado");
        deputado.setProximoMembro(ministro);

        System.out.println("Mensagem 1");
        deputado.lerMensagem(mensagem1);
        System.out.println("Mensagem 2");
        deputado.lerMensagem(mensagem2);
        System.out.println("Mensagem 3");
        deputado.lerMensagem(mensagem3);
    }
}
