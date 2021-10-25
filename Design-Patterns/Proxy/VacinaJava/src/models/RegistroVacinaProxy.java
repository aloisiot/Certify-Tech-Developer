package models;

import java.util.Date;

public class RegistroVacinaProxy implements IRegistroVacina{

    @Override
    public void registrar(Object[] dados) {
        if(verificarData((Date)dados[1])){
            RegistroVacina registroVacina = new RegistroVacina();
            registroVacina.registrar(dados);
        }
    }

    private boolean verificarData(Date data){
        return data.before(new Date());
    }
}
