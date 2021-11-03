import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static Connection connection = null;

    private static final String CREATE_TABLE_USUARIO =
            "DROP TABLE IF EXISTS usuario;" +
                    "CREATE TABLE usuario(" +
                    "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(100) NOT NULL," +
                    "sobrenome VARCHAR(100) NOT NULL," +
                    "idade INT NOT NULL" +
                    ");";

    public static void main(String[] args) throws Exception{

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_USUARIO);

            statement.execute(insertInto("Ana", "Santos", 20));
            statement.execute(insertInto("Marcia", "Valadares", 32));
            statement.execute(insertInto("Pedro", "Souza", 43));
            LOGGER.info("Usuários inseridos com sucesso!");
        }
        catch (Exception e) {
            LOGGER.error("A conexão com o banco de dados falhou!", e);
        }
        finally {
            if(connection != null)
                connection.close();
            LOGGER.info("Conexão com o banco de dados encerrada!");
        }
    }

    private static String insertInto(String nome, String sobrenome, int idade){
        return String.format("INSERT INTO usuario (nome, sobrenome, idade) VALUES ('%s', '%s', '%s');", nome, sobrenome, idade);
    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
