package impl;

import java.sql.SQLException;

public interface IDao<T> {
    T salvar(T t) throws SQLException;

    T buscar(int id) throws SQLException;
}
