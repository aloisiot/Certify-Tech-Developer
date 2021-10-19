package repository;

import models.Voo;

import java.util.ArrayList;
import java.util.List;

public class Voos {
    private List<Voo> voos = new ArrayList<>();
    private static Voos instance = new Voos();

    private Voos(){}

    public static Voos getInstance() {
        return instance;
    }

    public boolean addVoo(String dataPartida, String dataRetorno, String cidade){
        Voo voo = new Voo(dataPartida, dataRetorno, cidade);
        if(voo.getDataPartida()!= null && voo.getDataRetorno() != null){
            voos.add(voo);
            return true;
        }
        return false;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public Voo searchVoo(String dataPartida, String dataRetorno, String cidade){
        for(Voo v : voos){
            if(v.getDataPartida() == dataPartida && v.getDataRetorno() == dataRetorno && v.getCidade() == cidade)
                return v;
        }
        return null;
    }

}
