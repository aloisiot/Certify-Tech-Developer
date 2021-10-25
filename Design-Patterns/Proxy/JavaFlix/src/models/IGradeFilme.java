package models;

import throwables.FilmeNaoHabilitadoException;

public interface IGradeFilme {
    Filme getFilme(Cliente cliente, String nomeFilme) throws FilmeNaoHabilitadoException;
}
