package models;

public class CheckLote extends CheckQuality{

    public CheckLote(CheckQuality nextCheckQuality) {
        super(nextCheckQuality);
    }

    @Override
    public String checkQuality(Artigo artigo){
        String result;
        if(2000 >= artigo.getLote() && artigo.getLote() >= 1000){
            if(this.getNextCheckQuality() != null){
                result = this.getNextCheckQuality().checkQuality(artigo);
            } else {
                result = "aceito";
            }
        } else {
            result = "rejeitado";
        }
        return result;
    };
}
