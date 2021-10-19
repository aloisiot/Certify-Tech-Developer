package repository;

import models.Hospedagem;
import models.Voo;

import java.util.ArrayList;
import java.util.List;

public class Hospedagens {
    private List<Hospedagem> hospedagens = new ArrayList<>();
    private static Hospedagens instance = new Hospedagens();

    private Hospedagens(){}

    public static Hospedagens getInstance() {
        return instance;
    }

    public boolean addHospedagem(String dataEntrada, String dataSaida, String cidade){
        Hospedagem hospedagem = new Hospedagem(dataEntrada, dataSaida, cidade);
        if(hospedagem.getDataEntrada() != null && hospedagem.getDataSaida() != null) {
            hospedagens.add(hospedagem);
            return true;
        }
        return false;
    }

    public List<Hospedagem> getHospedagens() {
        return hospedagens;
    }

    public Hospedagem searchHospedagem(String dataEntrada, String dataSainda, String cidade){
        for(Hospedagem h : hospedagens){
            if(h.getDataEntrada() == dataEntrada && h.getDataSaida() == dataSainda && h.getCidade() == cidade)
                return h;
        }
        return null;
    }
}
