package models;

public class Mail {
    private String assunto;
    private String Conteudo;
    private String origem;
    private String destinatario;

    public Mail(String assunto, String conteudo, String origem, String destinatario) {
        this.assunto = assunto;
        Conteudo = conteudo;
        this.origem = origem;
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestinatario() {
        return destinatario;
    }
}
