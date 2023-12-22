package com.example.projectpattern;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static com.example.projectpattern.PersonalityTypeDAO.calculateResult;

//import static com.example.projectpattern.AfterFinishJ.calculateResult;

public class HomeJ {

    @FXML
    private Label I1;

    @FXML
    private Label Intj1;

    @FXML
    private Button activ;

    @FXML
    private Button books;

    @FXML
    private TextField email;

    @FXML
    private Button events;

    @FXML
    private Button help;

    @FXML
    private Button home;

    @FXML
    private Label i2;

    @FXML
    private ImageView imgView;

    @FXML
    private Label intj2;

    @FXML
    private Label intj3;

    @FXML
    private Label intj4;

    @FXML
    private Label j1;

    @FXML
    private Label j2;

    @FXML
    private Label mbtiType;

    @FXML
    private Label n1;

    @FXML
    private Label n2;

    @FXML
    private Button setting;

    @FXML
    private Label t1;

    @FXML
    private Label t2;

    @FXML
    private Button takeTest;

    @FXML
    private Label typeText;

    @FXML
    private Button types;

    private Stage stage1;
    Parent root;

    @FXML
    void initialize()  {
        String result = calculateResult();
        mbtiType.setText(result);
        //TypeText.setText();

        takeTest.setOnAction(event ->{
            try {
                root= FXMLLoader.load(getClass().getResource("AfterLog.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();
        } );
        setting.setOnAction(event ->{
            try {
                root= FXMLLoader.load(getClass().getResource("Setting.fxml"));
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
        activ.setOnAction(event -> {
            books.setStyle("-fx-background-color: #DDDDDD; -fx-background-radius: 25; -fx-text-fill: #ffffff;");
            activ.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 25; -fx-text-fill: #5db2b5;");
            events.setStyle("-fx-background-color: #DDDDDD; -fx-background-radius: 25; -fx-text-fill: #ffffff;");
        });
        events.setOnAction(event -> {
            books.setStyle("-fx-background-color: #DDDDDD; -fx-background-radius: 25; -fx-text-fill: #ffffff;");
            activ.setStyle("-fx-background-color: #DDDDDD; -fx-background-radius: 25; -fx-text-fill: #ffffff;");
            events.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 25; -fx-text-fill: #5db2b5;");
        });
        books.setOnAction(event -> {
            books.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 25; -fx-text-fill: #5db2b5;");
            activ.setStyle("-fx-background-color: #DDDDDD; -fx-background-radius: 25; -fx-text-fill: #ffffff;");
            events.setStyle("-fx-background-color: #DDDDDD; -fx-background-radius: 25; -fx-text-fill: #ffffff;");
        });
    }

}


