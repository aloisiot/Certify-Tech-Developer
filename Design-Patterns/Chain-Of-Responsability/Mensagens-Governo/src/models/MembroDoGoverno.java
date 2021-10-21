package models;

public abstract class MembroDoGoverno {
    private int grauHierarquico;
    private String CARGO;
    private MembroDoGoverno proximoMembro;

    public MembroDoGoverno(int grauHierarquico, String CARGO) {
        this.grauHierarquico = grauHierarquico;
        this.CARGO = CARGO;
    }

    public void lerMensagem(Mensagem mensagem) {
        if(mensagem.permitirLeitura(this.getGrauHierarquico())){
            System.out.printf("O sr. %s tem permissões para ler a mensagem!%n", this.CARGO);
            System.out.printf("Conteudo da mensagem: %s%n%n", mensagem.getConteudo());
        } else if(this.proximoMembro != null){
            this.proximoMembro.lerMensagem(mensagem);
        }
    }

    public int getGrauHierarquico(){
        return grauHierarquico;
    }

    public void setProximoMembro(MembroDoGoverno proximoMembro) {
        this.proximoMembro = proximoMembro;
    }
}
