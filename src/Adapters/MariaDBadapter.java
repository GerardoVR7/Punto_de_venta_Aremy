package Adapters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBadapter {
    private static MariaDBadapter instancia=null;;
    private static Connection connection =null;

    public static MariaDBadapter getInstancia() {
        if(instancia==null) {
            instancia = new MariaDBadapter();
            instancia.Connection();
        }
        return instancia;
    }

    public void Connection() {
        String connectionString = "jdbc:mariadb://localhost:3307/gamezone?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
        String user = "root";
        String password = "GVR7321";
        try {
            connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println(connection.getClass().getCanonicalName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Connection getConnection() {
        return connection;
    }

}
