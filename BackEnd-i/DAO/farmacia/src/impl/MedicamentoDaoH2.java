package impl;

import models.Medicamento;
import org.apache.log4j.Logger;
import configurations.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentoDaoH2 implements IDao<Medicamento>{
    private DBConnection connection;
    private static final Logger LOGGER = Logger.getLogger(MedicamentoDaoH2.class);

    public MedicamentoDaoH2(DBConnection connection) {
        this.connection = connection;
    }

    @Override
    public Medicamento salvar(Medicamento medicamento) throws SQLException {
        LOGGER.debug("Registrando novo medicamento: " + medicamento.toString());
        Connection c = this.connection.getConnection();
        Statement statement = null;
        String query = String.format("INSERT INTO medicamentos (nome, laboratorio, quantidade, preco)" +
                "VALUES ('%s', '%s', '%s', '%s');",
                medicamento.getNome(), medicamento.getLaboratorio(), medicamento.getQuantidade(), medicamento.getPreco());

        try{
            statement = c.createStatement();
            statement.execute(query);
            ResultSet keys = statement.getGeneratedKeys();
            LOGGER.debug("Medicamento registrado com sucesso!");

            if(keys.next()){
                medicamento.setId(keys.getInt(1));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(statement != null) statement.close();
            if(c != null) c.close();
            LOGGER.debug("Conexao finalizada!");
        }

        return medicamento;
    }

    @Override
    public Medicamento buscar(int id) throws SQLException {
        LOGGER.debug("buscando medicamento com id: " + id);
        Connection c = this.connection.getConnection();
        Statement statement = null;
        String query = String.format("SELECT * FROM medicamentos WHERE id = %d;", id);
        Medicamento result = null;

        try{
            statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                result = new Medicamento(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantidade"),
                        resultSet.getString("nome"),
                        resultSet.getString("laboratorio"),
                        resultSet.getDouble("preco")
                );
            }
            LOGGER.debug("Busca realizada com suceso");
        } catch (SQLException e) {
            LOGGER.error("Falha na busca", e);
        }
        finally {
            if(statement != null) statement.close();
            if(c != null) c.close();
            LOGGER.debug("Conexao finalizada!");
        }

        return result;
    }
}
