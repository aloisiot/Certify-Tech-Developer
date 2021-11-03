package configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String driver;
    private String url;
    private String user;
    private String password;

    public DBConnection(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public DBConnection(){
        this.driver = "org.h2.Driver";
        this.url = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'src/create.sql'";
        this.user = "sa";
        this.password = "";
    }

    public Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(this.url, this.user, this.password);
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return connection;
    }
}
