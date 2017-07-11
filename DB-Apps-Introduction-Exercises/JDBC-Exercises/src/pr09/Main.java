package pr09;

import connection.Connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            Connector.initConnection();
            connection = Connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            int targetMinionId = 0;
            try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))){
                targetMinionId = Integer.valueOf(buffReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            String sql = "CALL usp_get_older(" + targetMinionId + ")";
            try (CallableStatement callableStatement = connection.prepareCall(sql)){
                callableStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            sql = "SELECT m.name, m.age FROM minions AS m WHERE m.id = " + targetMinionId;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String minionName = resultSet.getString(1);
                    int minionAge = resultSet.getInt(2);
                    System.out.printf("%s %d%n", minionName, minionAge);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
