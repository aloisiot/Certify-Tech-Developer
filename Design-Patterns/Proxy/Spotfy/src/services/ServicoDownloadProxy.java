package services;

import models.Usuario;

public class ServicoDownloadProxy implements IServicoDownload {

    @Override
    public void downloadMusica(Usuario usuario) {
        if(verificaUsuario(usuario)){
            ServicoDownload servico = new ServicoDownload();
            servico.downloadMusica(usuario);
        } else {
            System.out.printf("O usuário %d não possui permições para download!%n", usuario.getId());
        }
    }

    private boolean verificaUsuario(Usuario usuario){
        return usuario.getTipo().equalsIgnoreCase("premium");
    }
}
