package es.adrianroguez.controller;

import es.adrianroguez.config.ConfigManager;
import es.adrianroguez.controller.abstracts.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class RememberPasswordController extends AbstractController {
    @FXML
    private Button goBackButton;
    @FXML
    private Label tituloRememberPassword;
    @FXML
    private Label emailLabel;
    @FXML
    private Text mensajeLabel;
    @FXML
    private Button sendButton;

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    public void cambiarIdioma() {
        goBackButton.setText(ConfigManager.ConfigProperties.getProperty("goBackButton"));
        emailLabel.setText(ConfigManager.ConfigProperties.getProperty("emailLabel"));
        tituloRememberPassword.setText(ConfigManager.ConfigProperties.getProperty("tituloRememberPassword"));
        sendButton.setText(ConfigManager.ConfigProperties.getProperty("sendButton"));
    }

    @FXML
    private void goBack(ActionEvent event) {
        cambiarPantalla(event, "/view/loginView.fxml");
    }
}
