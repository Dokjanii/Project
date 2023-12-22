package com.example.projectpattern;

import java.sql.*;

public class PersonalityTypeDAO {
    public static String calculateResult() {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "lolazz15";
        String showResult = null;
        String username = getLatestInsertedUsername(dbUrl, dbUser, dbPassword);

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String query = "SELECT extr_inti, sens_intu, thin_feel, judg_perc FROM score WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the user ID for whom you want to retrieve the values
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int extr_intr = resultSet.getInt("extr_inti");
                int sens_intu = resultSet.getInt("sens_intu");
                int thin_feel = resultSet.getInt("thin_feel");
                int judg_perc = resultSet.getInt("judg_perc");

                StringBuilder result = new StringBuilder();

                if (extr_intr < 3) result.append("I");
                else result.append("E");

                if (sens_intu < 3) result.append("N");
                else result.append("S");

                if (thin_feel < 3) result.append("F");
                else result.append("T");

                if (judg_perc < 3) result.append("P");
                else result.append("J");

                String type = String.valueOf(result);
                showResult = type;

                System.out.println(type);

                updateScoreInDatabase(showResult);
            } else {
                System.out.println("No data");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showResult;
    }


    private static void updateScoreInDatabase(String result) {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "lolazz15";

        String username = getLatestInsertedUsername(dbUrl, dbUser, dbPassword);
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String updateQuery = "UPDATE score SET result = ? WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, result);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getLatestInsertedUsername(String connectionString, String usernameDatabase, String passwordDatabase) {
        String query = "SELECT username " +
                "FROM visiting " +
                "WHERE insertion_time = (SELECT MAX(insertion_time) FROM visiting)";

        String latestUsername = null;

        try (Connection connection = DriverManager.getConnection(connectionString, usernameDatabase, passwordDatabase);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                latestUsername = resultSet.getString("username");
                System.out.println("Latest inserted username: " + latestUsername);
            } else {
                System.out.println("No username found based on the condition.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return latestUsername;
    }

    public static String calculateTypename() {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "lolazz15";
        String code = calculateResult();
        String typeName = null;

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String query = "SELECT type_name FROM personalityTypes WHERE type_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                typeName = resultSet.getString("type_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeName;
    }

    public static String calculateTypeDescription() {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "lolazz15";
        String code = calculateResult();
        String typeDescription = null;

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String query = "SELECT type_description FROM personalityTypes WHERE type_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                typeDescription = resultSet.getString("type_description");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeDescription;
    }
    public static String calculateTypeQuote() {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "lolazz15";
        String code = calculateResult();
        String typeQuote = null;

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String query = "SELECT type_quote FROM personalityTypes WHERE type_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                typeQuote = resultSet.getString("type_quote");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeQuote;
    }
    public static String calculateQuoteAuthor() {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "lolazz15";
        String code = calculateResult();
        String quoteAuthor = null;


        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String query = "SELECT quote_author FROM personalityTypes WHERE type_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                quoteAuthor = resultSet.getString("quote_author");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quoteAuthor;
    }
}
