package com.example.projectpattern;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;

import static com.example.projectpattern.PersonalityTypeDAO.*;


public class AfterFinishJ {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField email;

    @FXML
    private Button help;

    @FXML
    private Button home;

    @FXML
    private Label mbti;
    @FXML
    private Label typename;

    @FXML
    private Button setting;

    @FXML
    private Button takeTest;
    @FXML
    private TextArea TypeText;

    @FXML
    private Label author;

    @FXML
    private Button types;

    @FXML
    private TextArea quote;
    private Stage stage1;
    Parent root;


    @FXML
    void initialize() {
        String result = calculateResult();
        String typeName = calculateTypename();
        String typeDescription = calculateTypeDescription();
        String typeQuote = calculateTypeQuote();
        String quoteAuthor = calculateQuoteAuthor();
        //String photo = calculatePhoto();
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

        mbti.setText(result);
        typename.setText(typeName);
        TypeText.setText(typeDescription);
        quote.setText(typeQuote);
        author.setText(quoteAuthor);
    }
}