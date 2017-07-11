package pr05;

import connection.Connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Connection connection = null;

        try {
            Connector.initConnection();
            connection = Connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String countryName;
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            countryName = buffReader.readLine();
        }

        if (connection != null) {
            String sql = "CALL usf_change_town_names_to_uppercase("
                    + "\'" + countryName + "\'" + ")";
            try (CallableStatement callableStatement = connection.prepareCall(sql)) {
                int affectedRows = callableStatement.executeUpdate();

                if (affectedRows == 0) {
                    System.out.println("No town names were affected.");
                } else {
                    System.out.printf("%d town names were affected.%n", affectedRows);
                    sql = "SELECT t.name FROM towns AS t INNER JOIN countries AS c ON" +
                            " t.country_id = c.id AND c.name = " + "\'" + countryName + "\'";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                        ResultSet changedTownNames = preparedStatement.executeQuery();
                        StringBuilder result = new StringBuilder();
                        result.append("[");

                        while (changedTownNames.next()) {
                            result.append(String.format("%s, ",
                                    changedTownNames.getString(1)));
                        }

                        result.setLength(result.length() - 2);
                        result.append("]");
                        System.out.println(result);
                    }

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
