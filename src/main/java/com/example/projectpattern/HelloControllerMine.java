package com.example.projectpattern;

import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloControllerMine {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button forgotBut;

    @FXML
    private Button loginBut;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerBut;

    @FXML
    private CheckBox rememberMe;

    @FXML
    private TextField user;
    private Stage stage1;
    Parent root;

    @FXML
    void initialize()  {
        registerBut.setOnAction(event ->{
            try {
                root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignInUp.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } );

        loginBut.setOnAction(event ->{
            try {
                jButton2ActionPerformed();
                try {
                    root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignInUp.fxml")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage1.setScene(scene);
                stage1.show();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } );



    }

    private void jButton2ActionPerformed() throws SQLException {
        login(user.getText(), password.getText());

    }

    private boolean login(String username, String password) throws SQLException {
        String loginSQL = "SELECT * FROM database2 WHERE username = ? AND password = ?";
        String connectionString = "jdbc:postgresql://localhost:5432/postgres";
        String usernameDatabase = "postgres";
        String passwordDatabase = "lolazz15";
        Connection connection = DriverManager.getConnection(connectionString, usernameDatabase, passwordDatabase);

        try (PreparedStatement preparedStatement = connection.prepareStatement(loginSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

}


