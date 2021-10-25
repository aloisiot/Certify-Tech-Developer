package repository;

import models.IGradeSeries;
import models.Serie;

import java.util.ArrayList;
import java.util.List;

public class GradeSeries implements IGradeSeries {
    private List<Serie> series = new ArrayList<>();
    private static GradeSeries grade;

    private GradeSeries(){}

    // Singletom pattern
    public static GradeSeries getInstance(){
        if(grade == null) grade = new GradeSeries();
        return grade;
    }

    public void addSerie(Serie serie){
        if(serie != null) series.add(serie);
    }

    @Override
    public Serie getSerie(String nomeSerie){
        for(Serie s : series){
            if(s.getNome().equalsIgnoreCase(nomeSerie)) {
                System.out.printf("%nSérie solicitada: %s%nLink: %s%n", nomeSerie, s.getLink());
                return s;
            }
        }
        return null;
    }

}
