package pr04;

import connection.Connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static final String TOWN_TABLE_NAME = "towns";
    private static final String VILLAIN_TABLE_NAME = "villains";

    public static void main(String[] args) throws IOException {
        Connection connection = null;

        try {
            Connector.initConnection();
            connection = Connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            String minionData;
            String villainData;

            try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
                minionData = buffReader.readLine();
                villainData = buffReader.readLine();
            }

            String[] minionTokens = minionData.split(" ");
            String minionName = minionTokens[0];
            int minionAge = Integer.valueOf(minionTokens[1]);
            String minionTown = minionTokens[2];

            String sql = "SELECT usf_is_town_exist(" + "\'" + minionTown  + "\'" + ")";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                boolean isTownExist = resultSet.getBoolean(1);
                if (!isTownExist) {
                    sql = "INSERT INTO " + TOWN_TABLE_NAME + "(" + "name" + ") " +
                            "VALUE (" + "\'" +  minionTown + "\'" + ")";
                    try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql)){
                        preparedStatement1.executeUpdate();
                        System.out.printf("Town %s was added to the database.%n", minionTown);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            String[] villainTokens = villainData.split(" ");
            String villainName = villainTokens[0];

            sql = "SELECT usf_is_villain_exist(" + "\'" + villainName  + "\'" + ")";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                boolean isVillainExist = resultSet.getBoolean(1);
                if (!isVillainExist) {
                    sql = "INSERT INTO " + VILLAIN_TABLE_NAME + "(" + "name" + ") " +
                            "VALUE (" + "\'" + villainName + "\'" + ")";
                    try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql)){
                        preparedStatement1.executeUpdate();
                        System.out.printf("Villain %s was added to the database.%n", villainName);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
