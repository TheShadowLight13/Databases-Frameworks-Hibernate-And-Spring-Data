package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String username = "root";
    private static final String password = "45350891";

    private static Connection connection = null;

    public static void initConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", username);
        connectionProps.put("password", password);
        connection = DriverManager.getConnection(URL, connectionProps);
    }

    public static Connection getConnection() {
        return connection;
    }
}
