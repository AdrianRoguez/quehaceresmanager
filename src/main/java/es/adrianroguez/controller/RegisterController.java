package es.adrianroguez.controller;

import es.adrianroguez.config.ConfigManager;
import es.adrianroguez.controller.abstracts.AbstractController;
import es.adrianroguez.model.UserModel;
import es.adrianroguez.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterController extends AbstractController {
    private final UserService userService = new UserService();

    @FXML
    private Button goBackButton;
    @FXML
    private Label tituloRegister;
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
    private Button registerButton;

    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    public void cambiarIdioma() {
        goBackButton.setText(ConfigManager.ConfigProperties.getProperty("goBackButton"));
        tituloRegister.setText(ConfigManager.ConfigProperties.getProperty("tituloRegister"));
        usuarioLabel.setText(ConfigManager.ConfigProperties.getProperty("usuarioLabel"));
        emailLabel.setText(ConfigManager.ConfigProperties.getProperty("emailLabel"));
        repeatEmailLabel.setText(ConfigManager.ConfigProperties.getProperty("repeatEmailLabel"));
        contraseniaLabel.setText(ConfigManager.ConfigProperties.getProperty("contraseniaLabel"));
        repeatContraseniaLabel.setText(ConfigManager.ConfigProperties.getProperty("repeatContraseniaLabel"));
        registerButton.setText(ConfigManager.ConfigProperties.getProperty("registerButton"));
    }

    @FXML
    private void registerUser(ActionEvent event) {
        String username = usuarioFieldRegister.getText().trim();
        String email = emailField.getText().trim();
        String repeatEmail = repeatEmailField.getText().trim();
        String password = contraseniaFieldRegister.getText().trim();
        String repeatPassword = repeatContraseniaField.getText().trim();

        if (username.isEmpty() || email.isEmpty() || repeatEmail.isEmpty() || password.isEmpty()
                || repeatPassword.isEmpty()) {
            mensajeLabel.setText("Por favor completa todos los campos.");
            return;
        }

        if (!email.equals(repeatEmail)) {
            mensajeLabel.setText("Los correos no coinciden.");
            return;
        }

        if (!password.equals(repeatPassword)) {
            mensajeLabel.setText("Las contraseñas no coinciden.");
            return;
        }

        if (userService.userExistsByEmail(email)) {
            mensajeLabel.setText("Ya existe un usuario registrado con este email.");
            return;
        }

        UserModel nuevoUsuario = new UserModel(username, repeatEmail, repeatPassword);
        boolean creado = userService.createUser(nuevoUsuario);

        if (creado) {
            System.out.println("Usuario registrado correctamente.");
            cambiarPantalla(event, "/view/loginView.fxml");
        } else {
            mensajeLabel.setText("No se pudo registrar el usuario. Intenta de nuevo.");
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        cambiarPantalla(event, "/view/loginView.fxml");
    }
}
