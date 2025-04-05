package es.adrianroguez.controllers;

import es.adrianroguez.controllers.abstracts.AbstractController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RememberPasswordController extends AbstractController {

    @FXML
    private Button goBackButton;

    @FXML
    public void initialize() {
        cambiarIdioma();
        cambiarIdiomaRememberPassword();
    }

    @FXML
    private void goBack() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) goBackButton.getScene().getWindow();
            stage.setTitle("Pantalla Registro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
