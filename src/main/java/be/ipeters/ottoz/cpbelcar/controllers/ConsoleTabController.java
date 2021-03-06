package main.java.be.ipeters.ottoz.cpbelcar.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import main.java.be.ipeters.ottoz.cpbelcar.services.CarSpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ConsoleTabController {

    @FXML private TextArea missionOverviewText;
    @FXML private ListView<String> missionsList;
    
    @Autowired
    @Qualifier("stringPrintWriter")
    private PrintWriter stackTraceWriter;
    
    @Autowired
    CarSpecsService service;
    private TabPaneManager tabManager;

    public void initialize() {
        ObservableList<String> missions = FXCollections.observableArrayList("Car1","Car2", "Car3", "Car4");
        missionsList.setItems(missions);
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        missionOverviewText.clear();
        final String selectedItem = missionsList.getSelectionModel().getSelectedItem();
        missionOverviewText.positionCaret(0);
        missionOverviewText.appendText(getInfo(selectedItem));
    }
    
    @Autowired
    private void setTabManager(TabPaneManager tabManager){
        this.tabManager = tabManager;
    }
 
    public String getInfo(String selectedItem) {
        String missionInfo = null ;
                
        try {
            missionInfo = service.getMissionInfo(selectedItem); 
            getLog().appendText("Sucessfully retrieved mission info for " + selectedItem + "\n");
        } catch (IOException exception) {
            exception.printStackTrace (stackTraceWriter);
            getLog().appendText(stackTraceWriter.toString() + "\n");
        }
        
        return missionInfo;
    }

    public TextArea getMissionOverviewText() {
        return missionOverviewText;
    }

    public ListView<String> getMissionsList() {
        return missionsList;
    }
    
    private TextArea getLog(){
        return tabManager.getVisualLog();
    }

}
