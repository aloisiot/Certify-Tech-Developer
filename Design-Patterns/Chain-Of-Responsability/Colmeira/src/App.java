import models.*;

public class App {
    public static void main(String[] args) {
        Mail mail = new Mail("Assunto importante",
                            "Precisamos nos falar pessoalmente!",
                              "gerencial@colmeia.com",
                           "comercial@colmeia.com");

        Mail mail1 = new Mail("Assunto relevante",
                            "Olá, bom dia ...",
                              "comercial@colmeia.com",
                           "gerencial@colmeia.com");

        HandlerMail h = new HandlerMail();
        h.process(mail);
        System.out.printf("%n");
        h.process(mail1);
    }
}
