import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class App {
    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(inseriIntoTeste("João"));
            statement.execute(inseriIntoTeste("Maria"));

            showDados(connection, "SELECT * FROM teste");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(connection != null)
            connection.close();
        }
    }

    private static final String sqlCreateTable = "CREATE TABLE IF NOT EXISTS teste (" +
            "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
            "nome VARCHAR(255) NOT NULL" +
            ");";

    private static String inseriIntoTeste(String nome){
        return String.format("INSERT INTO teste (nome) VALUES ('%s');",nome);
    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    private static void showDados(Connection connection, String sqlQuery) throws Exception{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()){
            System.out.printf("id: %s, nome: %s%n",resultSet.getInt(1), resultSet.getString(2));
        }
    }
}
