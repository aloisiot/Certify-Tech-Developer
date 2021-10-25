package models;

public class HandlerCheckQuality {
    public String check(Artigo artigo){
        CheckEmbalagem checkEmbalagem = new CheckEmbalagem(null);
        CheckPeso checkPeso = new CheckPeso(checkEmbalagem);
        CheckLote checkLote = new CheckLote(checkPeso);

        return checkLote.checkQuality(artigo);
    }
}
