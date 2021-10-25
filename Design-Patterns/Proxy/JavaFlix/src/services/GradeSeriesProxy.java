package services;

import models.IGradeSeries;
import models.Serie;
import repository.GradeSeries;
import throwables.SerieNaoHabilitadaException;

import java.util.Calendar;

public class GradeSeriesProxy implements IGradeSeries {
    private int acessosSemanais;
    private int primeiroAcesso;

    @Override
    public Serie getSerie(String nomeSerie) throws SerieNaoHabilitadaException {
        definePrimeiroAcesso();
        GradeSeries grade = GradeSeries.getInstance();
        Serie serie = grade.getSerie(nomeSerie);
        if(primeiroAcesso >= 7 || serie == null || acessosSemanais >= 5){
            throw new SerieNaoHabilitadaException(
                    acessosSemanais >= 5 ?
                    "Numero de acessos semanais exedido":
                    String.format("Série '%s' não disponivel", nomeSerie)
            );
        }
        acessosSemanais ++;
        return serie;
    }

    private void definePrimeiroAcesso(){
        if(Calendar.DAY_OF_YEAR - primeiroAcesso >= 7) primeiroAcesso = 0;
    }
}
