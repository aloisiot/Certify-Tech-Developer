import models.Serie;
import repository.GradeSeries;
import services.GradeSeriesProxy;
import throwables.SerieNaoHabilitadaException;

public class AppSeries {
    public static void main(String[] args) {
        Serie result;
        GradeSeries grade = GradeSeries.getInstance();
        GradeSeriesProxy proxy = new GradeSeriesProxy();

        Serie serie = new Serie("El Chapo");
        Serie serie1 = new Serie("Round 6");
        Serie serie2 = new Serie("Peak Blinders");

        grade.addSerie(serie);
        grade.addSerie(serie1);
        grade.addSerie(serie2);

        try{
            result = proxy.getSerie("El Chapo");
            result = proxy.getSerie("Outra série"); // Série inesistente na grade
        } catch (SerieNaoHabilitadaException e){
            System.err.println(e.getMessage());
        }

        try{
            result = proxy.getSerie("Peak Blinders");
            result = proxy.getSerie("Round 6");
            result = proxy.getSerie("Peak Blinders");
            result = proxy.getSerie("El Chapo");
            result = proxy.getSerie("El Chapo");
            result = proxy.getSerie("Round 6"); // Número de acessos semanais exedido
        } catch (SerieNaoHabilitadaException e){
            System.err.println(e.getMessage());
        }
    }
}
