

package com.example.projectpattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SettingJ {

    @FXML
    private Label LabEmail;

    @FXML
    private Button chEmail;

    @FXML
    private ImageView chEmailLabel;

    @FXML
    private Button chPass;

    @FXML
    private ImageView chPassLabel;

    @FXML
    private ImageView chUserLabel;

    @FXML
    private Button change;

    @FXML
    private TextField email;

    @FXML
    private Button help;

    @FXML
    private Button home;

    @FXML
    private TextField newV;

    @FXML
    private TextField old;

    @FXML
    private Label pass;

    @FXML
    private Button setting;

    @FXML
    private Button takeTest;

    @FXML
    private Button types;
    @FXML
    private Button username;

    @FXML
    private Button types1;

    @FXML
    private Label user;
    private Stage stage1;
    Parent root;

    private boolean changeEmailRequested = false;
    private boolean changePasswordRequested = false;
    private boolean changeUsernameRequested = false;

    @FXML
    void initialize() {
        // Your database connection information
        String connectionString = "jdbc:postgresql://localhost:5432/postgres";
        String usernameDatabase = "postgres";
        String passwordDatabase = "lolazz15";

        // user.setText();

        // Handle actions when buttons are clicked
        chEmail.setOnAction(event -> {
            // Set appropriate prompts and images for changing email
            old.setPromptText("Old Email");
            newV.setPromptText("New Email");
            chEmailLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_42.png"));
            chUserLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_43.png"));
            chPassLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_43.png"));

            // Set flag for changing email
            changeEmailRequested = true;
            changePasswordRequested = false;
            changeUsernameRequested = false;
        });

        username.setOnAction(event -> {
            // Set appropriate prompts and images for changing username
            old.setPromptText("Old Username");
            newV.setPromptText("New Username");
            chUserLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_42.png"));
            chEmailLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_43.png"));
            chPassLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_43.png"));

            // Set flag for changing username
            changeEmailRequested = false;
            changePasswordRequested = false;
            changeUsernameRequested = true;
        });

        chPass.setOnAction(event -> {
            // Set appropriate prompts and images for changing password
            old.setPromptText("Old Password");
            newV.setPromptText("New Password");
            chPassLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_42.png"));
            chUserLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_43.png"));
            chEmailLabel.setImage(new Image("C:\\Users\\User\\IdeaProjects\\ProjectPattern\\src\\main\\resources\\com\\example\\projectpattern\\photo\\img_43.png"));

            // Set flag for changing password
            changeEmailRequested = false;
            changePasswordRequested = true;
            changeUsernameRequested = false;
        });

        //...

        change.setOnAction(event -> {
            try (Connection connection = DriverManager.getConnection(connectionString, usernameDatabase, passwordDatabase)) {
                String oldValue = old.getText();
                String newValue = newV.getText();

                // Determine the action requested and perform the corresponding operation
                if (changeEmailRequested) {
                    changeEmailButton(connection, "email", oldValue, newValue);
                } else if (changePasswordRequested) {
                    changePasswordButton(connection, "password", oldValue, newValue);
                } else if (changeUsernameRequested) {
                    changeUsernameButton(connection, "username", oldValue, newValue);
                }
                // Reset flags
                changeEmailRequested = false;
                changePasswordRequested = false;
                changeUsernameRequested = false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        home.setOnAction(event ->{
            try {
                root= FXMLLoader.load(getClass().getResource("Home.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        });
        takeTest.setOnAction(event ->{
            try {
                root= FXMLLoader.load(getClass().getResource("Questions1.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } );
        types.setOnAction(event ->{
            try {
                root= FXMLLoader.load(getClass().getResource("PersTypes.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } );
        help.setOnAction(event ->{
            try {
                root= FXMLLoader.load(getClass().getResource("HelpCenter.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } );

        // Other button action handlers...

        /*change.setOnAction(event -> {
            //if(chEmail.isPressed()) {
                try (Connection connection = DriverManager.getConnection(connectionString, usernameDatabase, passwordDatabase)) {
                    // Assuming chEmail button is clicked to change email
                    // Get values from the text fields for old and new values
                    String oldValue = old.getText();
                    String newValue = newV.getText();

                    // Change the value in the database

                    Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                    confirmation.setTitle("Change email");
                    confirmation.setHeaderText(null);
                    changeEmailButton(connection, "email", oldValue, newValue);
                    confirmation.setContentText("Your email has been changed.");
                    confirmation.showAndWait();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
           // }
        });*/
    }

    // Method to update values in the database
    private void changeEmailButton(Connection connection, String changeStatement, String oldValue, String newValue) {
        String updateQuery = "UPDATE database2 SET email = ? WHERE email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, oldValue);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Email updated successfully.");
                Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                confirmation.setTitle("Change email");
                confirmation.setHeaderText(null);
                confirmation.setContentText("Your email has been changed.");
                confirmation.showAndWait();
            } else {
                System.out.println("Email not found in the database.");
                Alert confirmation = new Alert(Alert.AlertType.ERROR);
                confirmation.setTitle("Change password error");
                confirmation.setHeaderText(null);
                confirmation.setContentText("Password not found in the database.");
                confirmation.showAndWait();

            }

        } catch (SQLException e) {
            System.out.println("Error changing email in the database: " + e.getMessage());
        }
    }

    private void changePasswordButton(Connection connection, String changeStatement, String oldValue, String newValue) {
        String updateQuery = "UPDATE database2 SET password = ? WHERE password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, oldValue);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Password updated successfully.");
                Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                confirmation.setTitle("Change password");
                confirmation.setHeaderText(null);
                confirmation.setContentText("Your password has been changed.");
                confirmation.showAndWait();
            } else {
                System.out.println("Password not found in the database.");
                Alert confirmation = new Alert(Alert.AlertType.ERROR);
                confirmation.setTitle("Change password error");
                confirmation.setHeaderText(null);
                confirmation.setContentText("Password not found in the database.");
                confirmation.showAndWait();
            }

        } catch (SQLException e) {
            System.out.println("Error changing password in the database: " + e.getMessage());
        }
    }

    // Method to update username in the database
    private void changeUsernameButton(Connection connection, String changeStatement, String oldValue, String newValue) {
        String updateQuery = "UPDATE database2 SET username = ? WHERE username = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, oldValue);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Username updated successfully.");
                Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                confirmation.setTitle("Change username");
                confirmation.setHeaderText(null);
                confirmation.setContentText("Your username has been changed.");
                confirmation.showAndWait();
            } else {
                System.out.println("Username not found in the database.");
                Alert confirmation = new Alert(Alert.AlertType.ERROR);
                confirmation.setTitle("Change username error");
                confirmation.setHeaderText(null);
                confirmation.setContentText("Username not found in the database.");
                confirmation.showAndWait();
            }

        } catch (SQLException e) {
            System.out.println("Error changing username in the database: " + e.getMessage());
        }
    }
}
