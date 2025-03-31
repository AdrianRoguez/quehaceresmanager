package es.adrianroguez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

        stage.setTitle("QuehaceresManager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
