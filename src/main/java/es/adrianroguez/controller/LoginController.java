package es.adrianroguez.controller;

import java.util.HashMap;
import java.util.Map;

import es.adrianroguez.config.ConfigManager;
import es.adrianroguez.controller.abstracts.AbstractController;
import es.adrianroguez.model.UserModel;
import es.adrianroguez.service.UserService;
import es.adrianroguez.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController extends AbstractController {
    private final String pathIdioma = "src/main/resources/";
    private final String idiomaString = "idioma-";
    private final Map<String, String> idiomaCodigoMap = new HashMap<>();

    @FXML
    private Button registerButton;
    @FXML
    private Label tituloLogin;
    @FXML
    private ComboBox<String> idiomaComboBox;
    @FXML
    private TextField usuarioField;
    @FXML
    private PasswordField contraseniaField;
    @FXML
    private Text mensajeLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button rememberPasswordButton;

    @FXML
    public void initialize() {
        idiomaCodigoMap.put("Español", "es");
        idiomaCodigoMap.put("English", "en");
        idiomaCodigoMap.put("Français", "fr");
        idiomaComboBox.getItems().addAll(idiomaCodigoMap.keySet());

        cargarIdioma("es");
        cambiarIdioma();
    }

    @FXML
    protected void seleccionarIdioma() {
        String idiomaSeleccionado = idiomaComboBox.getValue();
        if (idiomaSeleccionado != null) {
            String codigoIdioma = idiomaCodigoMap.get(idiomaSeleccionado);
            cargarIdioma(codigoIdioma);
            cambiarIdioma();
        }
    }

    private void cargarIdioma(String idioma) {
        String pathCargarIdioma = pathIdioma + idiomaString + idioma + ".properties";
        ConfigManager.ConfigProperties.setPath(pathCargarIdioma);
    }

    private void cambiarIdioma() {
        registerButton.setText(ConfigManager.ConfigProperties.getProperty("registerButton"));
        tituloLogin.setText(ConfigManager.ConfigProperties.getProperty("tituloLogin"));
        usuarioField.setPromptText(ConfigManager.ConfigProperties.getProperty("usuarioField"));
        contraseniaField.setPromptText(ConfigManager.ConfigProperties.getProperty("contraseniaField"));
        mensajeLabel.setText(ConfigManager.ConfigProperties.getProperty("mensajeLabel"));
        loginButton.setText(ConfigManager.ConfigProperties.getProperty("loginButton"));
        rememberPasswordButton.setText(ConfigManager.ConfigProperties.getProperty("rememberPasswordButton"));
    }

    public void loginUser(ActionEvent event) {
        String username = usuarioField.getText();
        String password = contraseniaField.getText();

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            mensajeLabel.setText("Por favor, rellena todos los campos.");
            return;
        }

        UserService userService = new UserService();
        boolean credencialesValidas = userService.validateCredentials(username, password);
        UserModel usuario = userService.getUserByCredentials(username, password);

        if (credencialesValidas) {
            Session.setCurrentUser(usuario);
            openMainScreen(event);
        } else {
            mensajeLabel.setText("Usuario o contraseña incorrectos.");
        }
    }

    public void openMainScreen(ActionEvent event) {
        cambiarPantalla(event, "/view/mainScreenView.fxml");
    }

    /**
     * Metodo para abrir la ventana de registro.
     */
    public void openRegister(ActionEvent event) {
        cambiarPantalla(event, "/view/registerView.fxml");
    }

    /**
     * Metodo para abrir la ventana de recuperacion de contrasenia.
     */
    public void openRememberPassword(ActionEvent event) {
        cambiarPantalla(event, "/view/rememberPasswordView.fxml");
    }

}
