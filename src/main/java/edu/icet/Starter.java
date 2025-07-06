package edu.icet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/customer_fxml/customerDash.fxml")))));
        primaryStage.getIcons().add(new Image("/img/dashboard.png"));
        primaryStage.setTitle("Customer Manage Dashboard");
        primaryStage.setResizable(false);
        primaryStage.show();
//        DBConnection.getInstance();

        //application exits
        primaryStage.setOnCloseRequest(e-> {
            Platform.exit(); // dispose the JavaFX toolkit
            System.exit(0); // shutdown the JVM
        });

    }

}
