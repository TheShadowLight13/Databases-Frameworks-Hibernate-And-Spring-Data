package pr07;

import connection.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            List<String> minionNames = new ArrayList<>();
            String sql = "SELECT m.name AS minion_name FROM minions AS m";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    minionNames.add(resultSet.getString(1));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            printMinionNames(minionNames);
        }
    }

    private static void printMinionNames(List<String> minionNames) {
        int offset = 1;
        for (int i = 0; i < minionNames.size() / 2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(minionNames.size() - offset));
            offset++;
        }

        if (minionNames.size() % 2 != 0) {
            System.out.println(minionNames.get(minionNames.size() / 2));
        }
    }
}
