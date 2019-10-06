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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ChooseACarController implements Initializable {
    @FXML
    TabPane tabPane;
    @FXML
    private Label label;
    @FXML
    Tab tab1, tab2;

    @FXML
    private Button btnExit, btnReturn;
    private final static Logger log = LoggerFactory.getLogger(ChooseACarController.class);

    private static final String URL = "jdbc:mysql://localhost:3306/belcar";

    @FXML
    private void handleBtnExitAction(ActionEvent event){
        System.out.println("exit");
        Platform.exit();
    }
    @FXML
    public void back2StartScreenButtonPushed(ActionEvent event) throws IOException
    {
        System.out.println("back to first screen.");
        Parent startParent = FXMLLoader.load(getClass().getResource("/Belcar.fxml"));
        Scene startScene = new Scene(startParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(startScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("ChooseACarController init");
//        tab2.setText("BS2");

    }
}
