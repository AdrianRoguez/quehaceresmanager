package es.adrianroguez.controllers;

import java.io.IOException;

import es.adrianroguez.controllers.abstracts.AbstractController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController extends AbstractController {

    @FXML
    private Button userButton;
    @FXML
    private Button desconectarseButton;
    @FXML
    private Button agregarButton;

    @FXML
    public void initialize() {
        cambiarIdioma();
        cambiarIdiomaMain();
    }

    /**
     * Metodo para desconectarse y volver a la pantalla de login
     */
    @FXML
    private void goBack() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) desconectarseButton.getScene().getWindow();
            stage.setTitle("Pantalla de Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ir a la pantalla de usuario con la información del usuario
     * actual
     */
    @FXML
    private void openUser() {
        String usuario = LoginController.getUsuarioActual();

        if (usuario == null || usuario.isEmpty()) {
            System.out.println("Error: Usuario no establecido en LoginController.");
            return;
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/user.fxml"));
            Scene userScene = new Scene(fxmlLoader.load());

            UserController userController = fxmlLoader.getController();
            userController.inicializarUsuario(usuario);

            Stage stage = (Stage) userButton.getScene().getWindow();
            stage.setScene(userScene);
            stage.setTitle("Información de Usuario");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
