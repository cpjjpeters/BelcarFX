package main.java.be.ipeters.ottoz.cpbelcar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Cpbelcar extends Application {
    private final static Logger log = (Logger) LoggerFactory.getLogger(Cpbelcar.class);
//static Logger logger = LoggerFactory.getLogger(Cpbelcar.class);
    @SuppressWarnings("unused")
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) {
        System.out.println("start CpbelcarApplication");
        log.info("start CpbelcarApplication");
//        logger.info("start CpbelcarApplication");
//        SpringApplication.run(Cpbelcar.class, args);
//		System.out.println("line1");

//        log.trace("A TRACE Message");
//        log.debug("A DEBUG Message");
//        log.info("An INFO Message");
//        log.warn("A WARN Message");
//        log.error("An ERROR Message");
        Application.launch();
        System.out.println("ENDED");
        log.info("ending!");
    }
    @Override
    public void init() throws Exception{
        springContext = SpringApplication.run(Cpbelcar.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/be/ipeters/ottoz/cpbelcar/fxml/Belcar.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BelcarFX");
        stage.setScene(new Scene(rootNode, 800,600));
        stage.show();

    }

    @Override
    public void stop() throws Exception{
        springContext.close();
    }
}
