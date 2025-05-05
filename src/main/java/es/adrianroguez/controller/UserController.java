package es.adrianroguez.controller;

import es.adrianroguez.config.ConfigManager;
import es.adrianroguez.controller.abstracts.AbstractController;
import es.adrianroguez.model.UserModel;
import es.adrianroguez.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserController extends AbstractController {
    @FXML
    private Label tituloUsuario;
    @FXML
    private Label usuarioLabel;
    @FXML
    private Label usernameInfo;
    @FXML
    private Label emailLabel;
    @FXML
    private Label emailInfo;
    @FXML
    private Button goBackButton;

    @FXML
    public void initialize() {
        cambiarIdiomas();
        cargarDatosUsuario();
    }

    private void cambiarIdiomas() {
        tituloUsuario.setText(ConfigManager.ConfigProperties.getProperty("tituloUsuario"));
        usuarioLabel.setText(ConfigManager.ConfigProperties.getProperty("usuarioLabel"));
        emailLabel.setText(ConfigManager.ConfigProperties.getProperty("emailLabel"));
        goBackButton.setText(ConfigManager.ConfigProperties.getProperty("goBackButton"));
    }

    /**
     * 
     * @param event
     */
    private void cargarDatosUsuario() {
        UserModel usuarioActual = Session.getCurrentUser();
        if (usuarioActual != null) {
            usernameInfo.setText(usuarioActual.getUsername());
            emailInfo.setText(usuarioActual.getEmail());
        }
    }

    /**
     * Metodo para abrir la ventana de user.
     */
    public void openEditUser(ActionEvent event) {
        cambiarPantalla(event, "/view/editUserView.fxml");
    }

    @FXML
    private void goBack(ActionEvent event) {
        cambiarPantalla(event, "/view/mainScreenView.fxml");
    }

}
