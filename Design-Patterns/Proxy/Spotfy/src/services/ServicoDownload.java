package services;

import models.Usuario;

public class ServicoDownload implements IServicoDownload {

    public void downloadMusica(Usuario usuario){
        System.out.printf("Baixando a musica a pedido do ususario %d!%n", usuario.getId());
    }

}
