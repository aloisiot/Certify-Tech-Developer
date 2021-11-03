import org.apache.log4j.Logger;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static Connection connection = null;

    private static final String CREATE_TABLE_FUNCIONARIOS = "DROP TABLE IF EXISTS funcionarios;" +
            "CREATE TABLE funcionarios (" +
                "id INT NOT NULL PRIMARY KEY," +
                "nome VARCHAR(100) NOT NULL," +
                "sobrenome VARCHAR(100) NOT NULL," +
                "idade INT NOT NULL" +
            ");";

    private static String insertInto(int id, String nome, String sobrenome, int idade){
        return String.format("INSERT INTO funcionarios (id, nome, sobrenome, idade) VALUES (%d, '%s', '%s', %d);",id, nome, sobrenome, idade);
    }

    private static final String UPDATE = "UPDATE funcionarios SET id=5 WHERE id=1";

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    public static void main(String[] args) throws SQLException {

        try{

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_FUNCIONARIOS);

            statement.execute(insertInto(1, "Joao", "Silva", 23));

            // Atualizando id do primeiro registro. Evitando assim erro de PK duplicada nas linhas abaixo.
            statement.execute(UPDATE);
            LOGGER.debug("ID atualizado com sucesso!");

            statement.execute(insertInto(1, "Davi", "Santos", 33));
            statement.execute(insertInto(2, "Maria", "Ferreira", 28));
            statement.execute(insertInto(3, "Tiago", "Valadares", 45));
            LOGGER.info("Usuarios inseridos com sucesso!!");

        }
        catch (JdbcSQLIntegrityConstraintViolationException e){
            LOGGER.error("Regra de chave primaria unica violada!", e);
        }
        catch(Exception e){
            LOGGER.error("A conexao com o banco de dados falhou!", e);
        }
        finally {
            connection.close();
            LOGGER.info("Conexao com o banco de dados encerrada!!");
        }
    }
}
