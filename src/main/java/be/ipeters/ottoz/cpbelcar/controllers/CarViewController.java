package main.java.be.ipeters.ottoz.cpbelcar.controllers;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.java.be.ipeters.ottoz.cpbelcar.domain.Car;
import main.java.be.ipeters.ottoz.cpbelcar.domain.Car;
import main.java.be.ipeters.ottoz.cpbelcar.utils.DbHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

@Component
public class CarViewController implements Initializable {
    @FXML
    private Label label;
    private boolean isPossible=true;
    @FXML
    private Button loadBtn, btnExit, btnReturn, refreshBtn;
    private final static Logger log = LoggerFactory.getLogger(CarViewController.class);
    @FXML
    private TableView<Car> tvCar;
    @FXML
        private TableColumn<Car,String> colCarName;
    @FXML
    private TableColumn<Car,Integer> colStock;
    // variables
    private Connection conn, connection;
    private ObservableList<Car> list = FXCollections.observableArrayList();
    private DbHandler dbHandler;

    // method to populate TableView
    private void populateTabelView(){
        // select query string
        String query = "SELECT * FROM car";
        // run query and put results in resultset
        try {
            conn= dbHandler.getConnect();
            ResultSet set = conn.createStatement().executeQuery(query);
            // loop through resultset, extract data and append to our list

            while(set.next()){
                // create an product object, add data etc
                Car car = new Car();
                car.setId(set.getInt("id"));
                car.setName((set.getString("name")));
                car.setStock(set.getInt("stock"));
//                System.out.println("set.next car");
                list.add(car);
                isPossible=true;
            }
            if(list.size()==0) {
                System.out.println("No cars found");
                isPossible=false;
            }
            if(isPossible) {
//                colId.setCellValueFactory(new PropertyValueFactory<Car, Integer>("id"));
                colCarName.setCellValueFactory(new PropertyValueFactory<Car, String>("name"));
                colStock.setCellValueFactory(new PropertyValueFactory<Car, Integer>("stock"));
                // set data to tableview
                System.out.println("tvCar.setItems(list)");
                tvCar.setItems(list);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void refreshTable() throws Exception{
        list.clear();
        System.out.println("refreshTable");
        String query = "SELECT * FROM car";
        // run query and put results in resultset
        try {
            conn = dbHandler.getConnect();
            ResultSet set = conn.createStatement().executeQuery(query);
            // loop through resultset, extract data and append to our list
            while (set.next()){
                Car car = new Car();
                car.setId(set.getInt("id"));
                car.setName((set.getString("name")));
                car.setStock(set.getInt("stock"));
//                System.out.println("set.next car");
                list.add(car);
                isPossible=true;
                }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void loadTable() {
        list.clear();
        System.out.println("list.clear en loadTable");
        populateTabelView();
    }
    @FXML
    private void handleBtnExitAction(ActionEvent event){
        System.out.println("exit");
        Platform.exit();
    }
    @FXML
    private void loadButtons(){
        if(refreshBtn.getText().equalsIgnoreCase("refresh")) {
            refreshBtn.setText("ReFrEsH 1");
        }else {
            refreshBtn.setText("REFRESH");
        }

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
        // just trying to set the Button text here
        loadButtons();
        log.info("CarViewController, initialize");
        // import driver first
        // instantiate DB handler class
        dbHandler = new DbHandler();
        // run the method
        populateTabelView();

    }
}
