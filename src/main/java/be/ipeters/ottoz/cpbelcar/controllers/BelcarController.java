package main.java.be.ipeters.ottoz.cpbelcar.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.be.ipeters.ottoz.cpbelcar.Cpbelcar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

@Component
public class BelcarController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private Button btnExit, btnNext, btnGameTV,btnOrderACar,btnChooseACar;
    private final static Logger log = LoggerFactory.getLogger(BelcarController.class);

    private static final String URL = "jdbc:mysql://localhost:3306/belcar";

     public void change2CarViewButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/be/ipeters/ottoz/cpbelcar/fxml/CarView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        log.info("change2CarViewButtonPushed");
        window.setScene(tableViewScene);
        window.show();
    }

    public void change2OrderACarButtonPushed(ActionEvent event) throws IOException
    {
        log.info("change2OrderACarButtonPushed.");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/be/ipeters/ottoz/cpbelcar/fxml/OrderACar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void change2ChooseACarButtonPushed(ActionEvent event) throws IOException
    {
        log.info("change2ChooseACarButtonPushed.");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/be/ipeters/ottoz/cpbelcar/fxml/ChooseACar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    @FXML
    private void handleBtnExitAction(ActionEvent event){
        Platform.exit();
    }
    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        log.info("BelcarController, initialize");
    }

}
