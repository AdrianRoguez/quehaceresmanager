package es.adrianroguez.controller;

import es.adrianroguez.config.ConfigManager;
import es.adrianroguez.controller.abstracts.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class EditUserController extends AbstractController {
    @FXML
    private Button goBackButton;
    @FXML
    private Label tituloEditUser;
    @FXML
    private Label usuarioLabel;
    @FXML
    private TextField usuarioFieldRegister;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailField;
    @FXML
    private Label repeatEmailLabel;
    @FXML
    private TextField repeatEmailField;
    @FXML
    private Label contraseniaLabel;
    @FXML
    private PasswordField contraseniaFieldRegister;
    @FXML
    private Label repeatContraseniaLabel;
    @FXML
    private PasswordField repeatContraseniaField;
    @FXML
    private Text mensajeLabel;
    @FXML
    private Button saveButton;
    @FXML
    private Button deleteUserButton;

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    @FXML
    private void cambiarIdioma() {
        goBackButton.setText(ConfigManager.ConfigProperties.getProperty("goBackButton"));
        tituloEditUser.setText(ConfigManager.ConfigProperties.getProperty("tituloEditUser"));
        usuarioLabel.setText(ConfigManager.ConfigProperties.getProperty("usuarioLabel"));
        emailLabel.setText(ConfigManager.ConfigProperties.getProperty("emailLabel"));
        repeatEmailLabel.setText(ConfigManager.ConfigProperties.getProperty("repeatEmailLabel"));
        contraseniaLabel.setText(ConfigManager.ConfigProperties.getProperty("contraseniaLabel"));
        repeatContraseniaLabel.setText(ConfigManager.ConfigProperties.getProperty("repeatContraseniaLabel"));
        saveButton.setText(ConfigManager.ConfigProperties.getProperty("saveButton"));
        deleteUserButton.setText(ConfigManager.ConfigProperties.getProperty("deleteUserButton"));
    }

    @FXML
    private void goBack(ActionEvent event) {
        cambiarPantalla(event, "/view/userView.fxml");
    }
}
