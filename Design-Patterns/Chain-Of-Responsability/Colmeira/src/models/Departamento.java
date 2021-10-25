package models;

public abstract class Departamento {
    private String departamento;
    private Departamento nextHendlerMail;

    public Departamento(Departamento departamento, String nomeDepartamento) {
        this.nextHendlerMail = departamento;
        this.departamento = nomeDepartamento;
    }

    private boolean checkMail(Mail mail){
        if(this.departamento.equalsIgnoreCase(mail.getOrigem().split("@")[0])){
            return true;
        }
        return false;
    }

    public void readMail(Mail mail){
        if(this.checkMail(mail)){
            String assunto = mail.getAssunto();
            String origem = mail.getOrigem();
            String conteudo = mail.getConteudo();
            System.out.printf("Lido pelo departamento %s%n", this.departamento);
            System.out.printf("Assunto: %s%nOrigem %s%nConteudo: %s%n",assunto , origem, conteudo);
        } else if(this.getNextHendlerMail() != null) {
            this.getNextHendlerMail().readMail(mail);
        } else {
            HandleSpam.readMail(mail);
        }
    }

    public Departamento getNextHendlerMail() {
        return nextHendlerMail;
    }

    public void setNextHendlerMail(Departamento nextHendlerMail) {
        this.nextHendlerMail = nextHendlerMail;
    }
}
