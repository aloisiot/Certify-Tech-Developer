package models;

import throwables.SerieNaoHabilitadaException;

public interface IGradeSeries {
    Serie getSerie(String nomeSerie) throws SerieNaoHabilitadaException;
}
