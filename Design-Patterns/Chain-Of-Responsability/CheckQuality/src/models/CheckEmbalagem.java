package models;

public class CheckEmbalagem extends CheckQuality{
    public CheckEmbalagem(CheckQuality nextCheckQuality) {
        super(nextCheckQuality);
    }

    @Override
    public String checkQuality(Artigo artigo){
        String result;
        if(artigo.getEmbalagem().equalsIgnoreCase("saudavel")){
            if(this.getNextCheckQuality() != null){
                result = this.getNextCheckQuality().checkQuality(artigo);
            } else {
                result = "aceito";
            }
        } else {
            result = "rejeitado";
        }
        return result;
    }
}
