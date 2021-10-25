package models;

public abstract class HandleSpam{
    public static void readMail(Mail mail){
        String origem = mail.getOrigem();
        String assunto = mail.getAssunto();
        System.out.printf("Email marcado como spam:%n" +
                "Assunto: %s%nOrigem: %s%n",assunto, origem);
    }
}
