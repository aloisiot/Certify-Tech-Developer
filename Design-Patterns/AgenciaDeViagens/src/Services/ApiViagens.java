package Services;

import models.*;
import repository.*;

public class ApiViagens {
    Voos voosRepository = Voos.getInstance();
    Hospedagens hospedagensRepository = Hospedagens.getInstance();

    public String searchViagem(String dataInicial, String dataTermino, String cidade){
        Voo v = voosRepository.searchVoo(dataInicial, dataTermino, cidade);
        Hospedagem h = hospedagensRepository.searchHospedagem(dataInicial, dataTermino, cidade);

        return String.format("%s%n%s%n", v.toString(), h.toString());
    }

}
