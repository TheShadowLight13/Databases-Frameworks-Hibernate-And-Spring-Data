package pr08;

import connection.Connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            List<Integer> minionIds = new ArrayList<>();
            try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))){
                minionIds = Arrays.stream(buffReader.readLine().split(" "))
                        .map(Integer::valueOf).collect(Collectors.toList());

            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int minionId : minionIds) {
                String sql1 = "CALL usp_increment_age(" + minionId + ")";
                String sql2 = "CALL usp_make_name_title_case(" + minionId + ")";

                try (CallableStatement callableStatement = connection.prepareCall(sql1)){
                    callableStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try (CallableStatement callableStatement = connection.prepareCall(sql2)){
                    callableStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            String sql = "SELECT m.name, m.age FROM minions AS m";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();
                printResult(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String minionName = resultSet.getString(1);
            int minionAge = resultSet.getInt(2);
            System.out.printf("%s %d%n", minionName, minionAge);
        }
    }
}
