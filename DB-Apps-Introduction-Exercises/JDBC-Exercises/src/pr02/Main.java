package pr02;

import connection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static final int TARGET_COUNT = 3;

    public static void main(String[] args) {
        Connection connection = null;

        try {
            Connector.initConnection();
            connection = Connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            String sql = "SELECT v.name, COUNT(vm.minion_id) AS 'minions_count' FROM villains AS v " +
                    "INNER JOIN villains_minions AS vm " +
                    "ON v.id = vm.villain_id " +
                    "GROUP BY v.name " +
                    "HAVING minions_count > " + TARGET_COUNT +
                    " ORDER BY minions_count DESC";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet entries = preparedStatement.executeQuery();
                while (entries.next()) {
                    String villainName = entries.getString("name");
                    int minionsCount = entries.getInt("minions_count");
                    System.out.printf("%s %d%n", villainName, minionsCount);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
