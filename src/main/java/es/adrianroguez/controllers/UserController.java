package es.adrianroguez.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.adrianroguez.controllers.abstracts.AbstractController;
import es.adrianroguez.database.ConnectionDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserController extends AbstractController {

    @FXML
    private Label usernameInfo;

    @FXML
    private Label emailInfo;

    @FXML
    private Button goBackButton;

    private String usuarioActual;

    @FXML
    public void initialize() {
        cambiarIdioma();
        cambiarIdiomaUser();
    }

    /**
     * Metodo para inicializar la pantalla y cargar los datos del usuario
     * 
     * @param usuario Nombre de usuario que inicia sesion
     */
    public void inicializarUsuario(String usuario) {
        this.usuarioActual = usuario;
        System.out.println("Usuario actual en UserController: " + usuarioActual);
        cargarDatosUsuario();
    }

    /**
     * Carga la informacion del usuario desde la base de datos y la muestra en la
     * interfaz
     */
    private void cargarDatosUsuario() {
        if (usuarioActual == null || usuarioActual.isEmpty()) {
            System.out.println("Error: Usuario no proporcionado.");
            usernameInfo.setText("Usuario no encontrado");
            emailInfo.setText("Email no disponible");
            return;
        }

        String sql = "SELECT usuario, email FROM usuarios WHERE usuario = ?";

        try (Connection conn = ConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuarioActual);
            System.out.println("Ejecutando consulta SQL: " + sql + " con usuario: " + usuarioActual);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usernameInfo.setText(rs.getString("usuario"));
                    emailInfo.setText(rs.getString("email"));
                    System.out.println("Datos encontrados: " + rs.getString("usuario") + ", " + rs.getString("email"));
                } else {
                    System.out.println("No se encontró el usuario en la base de datos.");
                    usernameInfo.setText("Usuario no encontrado");
                    emailInfo.setText("Email no disponible");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            usernameInfo.setText("Error al cargar datos");
            emailInfo.setText("Error al cargar datos");
        } finally {
            ConnectionDB.closeConnection();
        }
    }

    /**
     * Metodo para volver a la pantalla main-screen
     */
    @FXML
    private void goBack() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main-screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) goBackButton.getScene().getWindow();
            stage.setTitle("Pantalla Principal");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
