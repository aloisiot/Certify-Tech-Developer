package models;

import java.util.Date;

public class RegistroVacina implements IRegistroVacina{

    @Override
    public void registrar(Object[] dados) {
        System.out.printf("Foi registrado o RG %s na data %s como vacinado", dados[0], new Date().toString());
    }
}
