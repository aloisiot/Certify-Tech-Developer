package models;

public class CheckPeso extends CheckQuality{
    public CheckPeso(CheckQuality nextCheckQuality) {
        super(nextCheckQuality);
    }

    @Override
    public String checkQuality(Artigo artigo) {
        String result;
        if(1200 <= artigo.getPeso() && artigo.getPeso() <= 1300){
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
