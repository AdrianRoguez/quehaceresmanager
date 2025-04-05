package es.adrianroguez.controllers.abstracts;

import es.adrianroguez.config.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AbstractController {

    @FXML
    private Button registerButton;
    @FXML
    private Label tituloLogin;
    @FXML
    private TextField usuarioField;
    @FXML
    private PasswordField contraseniaField;
    @FXML
    private Label mensajeLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button rememberPasswordButton;
    @FXML
    private Button goBackButton;
    //
    @FXML
    private Label tituloRegister;
    @FXML
    private Label usuarioLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label repeatEmailLabel;
    @FXML
    private Label contraseniaLabel;
    @FXML
    private Label repeatContraseniaLabel;
    //
    @FXML
    private Label tituloRememberPassword;
    @FXML
    private Button sendButton;
    //
    @FXML
    private Button desconectarseButton;
    @FXML
    private Button userButton;
    //
    @FXML
    private Label tituloUsuario;

    public void cambiarIdioma() {
        if (!(registerButton == null)) {
            registerButton.setText(ConfigManager.ConfigProperties.getProperty("registerButton"));
        }
        if (!(tituloLogin == null)) {
            tituloLogin.setText(ConfigManager.ConfigProperties.getProperty("tituloLogin"));
        }
        if (!(usuarioField == null)) {
            usuarioField.setPromptText(ConfigManager.ConfigProperties.getProperty("usuarioField"));
        }
        if (!(contraseniaField == null)) {
            contraseniaField.setPromptText(ConfigManager.ConfigProperties.getProperty("contraseniaField"));
        }
        if (!(mensajeLabel == null)) {
            mensajeLabel.setText(ConfigManager.ConfigProperties.getProperty("mensajeLabel"));
        }
        if (!(loginButton == null)) {
            loginButton.setText(ConfigManager.ConfigProperties.getProperty("loginButton"));
        }
        if (!(rememberPasswordButton == null)) {
            rememberPasswordButton.setText(ConfigManager.ConfigProperties.getProperty("rememberPasswordButton"));
        }
        if (!(goBackButton == null)) {
            goBackButton.setText(ConfigManager.ConfigProperties.getProperty("goBackButton"));
        }
    }

    public void cambiarIdiomaRegister() {
        tituloRegister.setText(ConfigManager.ConfigProperties.getProperty("tituloRegister"));

        usuarioLabel.setText(ConfigManager.ConfigProperties.getProperty("usuarioLabel"));

        emailLabel.setText(ConfigManager.ConfigProperties.getProperty("emailLabel"));

        repeatEmailLabel.setText(ConfigManager.ConfigProperties.getProperty("repeatEmailLabel"));

        contraseniaLabel.setText(ConfigManager.ConfigProperties.getProperty("contraseniaLabel"));

        repeatContraseniaLabel.setText(ConfigManager.ConfigProperties.getProperty("repeatContraseniaLabel"));
    }

    public void cambiarIdiomaRememberPassword() {
        tituloRememberPassword.setText(ConfigManager.ConfigProperties.getProperty("tituloRememberPassword"));

        sendButton.setText(ConfigManager.ConfigProperties.getProperty("sendButton"));
    }

    public void cambiarIdiomaMain() {
        desconectarseButton.setText(ConfigManager.ConfigProperties.getProperty("desconectarseButton"));

        userButton.setText(ConfigManager.ConfigProperties.getProperty("userButton"));
    }

    public void cambiarIdiomaUser() {
        tituloUsuario.setText(ConfigManager.ConfigProperties.getProperty("tituloUsuario"));

        usuarioLabel.setText(ConfigManager.ConfigProperties.getProperty("usuarioLabel"));

        emailLabel.setText(ConfigManager.ConfigProperties.getProperty("emailLabel"));
    }
}
