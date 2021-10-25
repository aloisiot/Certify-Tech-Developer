import models.IRegistroVacina;
import models.Pessoa;
import models.RegistroVacina;
import models.RegistroVacinaProxy;

import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        int ano = 2021;
        int mes = 11;
        int dia = 22;

        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes - 1, dia);
        Date data = calendar.getTime();
        Pessoa pessoa = new Pessoa("Maria", "Santos", "325335234", "A-que-tinha", data);

        IRegistroVacina registroVacina = new RegistroVacinaProxy();
        registroVacina.registrar(pessoa.dados());
    }
}
