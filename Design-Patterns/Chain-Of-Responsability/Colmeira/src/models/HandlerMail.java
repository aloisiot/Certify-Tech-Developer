package models;

public class HandlerMail {
    public void process(Mail mail){
        Gerencial gerencial = new Gerencial(null, "gerencial");
        Comercial comercial = new Comercial(gerencial, "comercial");
        Tecnico tecnico = new Tecnico(comercial, "tecnico");

        tecnico.readMail(mail);
    }
}
