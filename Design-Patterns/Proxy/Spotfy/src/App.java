import models.Usuario;
import services.ServicoDownloadProxy;

public class App {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "free");
        Usuario usuario1 = new Usuario(2, "premium");

        ServicoDownloadProxy servico = new ServicoDownloadProxy();
        servico.downloadMusica(usuario);
        servico.downloadMusica(usuario1);
    }
}
