package pr03;

import connection.Connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static Connection connection = null;

    public static void main(String[] args) throws IOException {
        try {
            Connector.initConnection();
            connection = Connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            int villainId;
            try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))){
                villainId = Integer.valueOf(buffReader.readLine());
            }

            String sql = "SELECT v.name AS 'villain_name', m.name AS 'minion_name', m.age AS 'minion_age' " +
                    "FROM villains AS v " +
                    "LEFT OUTER JOIN villains_minions AS vm " +
                    "ON v.id = vm.villain_id " +
                    "LEFT OUTER JOIN minions AS m " +
                    "ON m.id = vm.minion_id " +
                    "WHERE v.id = " + villainId;

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();
                int minionRow = 1;

                if (!resultSet.next()) {
                    System.out.printf("No villain with ID %d exists in the database.%n",
                            villainId);
                }else {
                    String villainName = resultSet.getString("villain_name");
                    System.out.printf("Villain: %s%n", villainName);
                    resultSet.previous();
                }

                while (resultSet.next()) {
                    String minionName = resultSet.getString("minion_name");
                    int minionAge = resultSet.getInt("minion_age");

                    if (minionName != null) {
                        System.out.printf("%d. %s: %d%n",
                                minionRow, minionName, minionAge);
                        minionRow++;
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
