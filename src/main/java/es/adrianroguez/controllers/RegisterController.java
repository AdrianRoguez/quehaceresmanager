package es.adrianroguez.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import es.adrianroguez.controllers.abstracts.AbstractController;
import es.adrianroguez.database.ConnectionDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController extends AbstractController {

    @FXML
    private TextField usuarioField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField repeatEmailField;
    @FXML
    private PasswordField contraseniaField;
    @FXML
    private PasswordField repeatContraseniaField;
    @FXML
    private Label mensajeLabel;
    @FXML
    private Button registerButton;
    @FXML
    private Button goBackButton;

    @FXML
    public void initialize() {
        cambiarIdioma();
        cambiarIdiomaRegister();
    }

    /**
     * Metodo para registrar un nuevo usuario en la base de datos
     */
    @FXML
    private void registrarUsuario() {
        String usuario = usuarioField.getText().trim();
        String email = emailField.getText().trim();
        String repetirEmail = repeatEmailField.getText().trim();
        String contrasenia = contraseniaField.getText().trim();
        String repetirContrasenia = repeatContraseniaField.getText().trim();

        if (usuario.isEmpty() || email.isEmpty() || repetirEmail.isEmpty() || contrasenia.isEmpty()
                || repetirContrasenia.isEmpty()) {
            mensajeLabel.setText("Todos los campos son obligatorios.");
            return;
        }

        if (!email.equals(repetirEmail)) {
            mensajeLabel.setText("Los correos electrónicos no coinciden.");
            return;
        }

        if (!contrasenia.equals(repetirContrasenia)) {
            mensajeLabel.setText("Las contraseñas no coinciden.");
            return;
        }

        if (usuarioExiste(usuario)) {
            mensajeLabel.setText("El usuario ya está registrado. Elige otro nombre.");
            return;
        }

        if (emailExiste(email)) {
            mensajeLabel.setText("El correo electrónico ya está registrado. Usa otro.");
            return;
        }

        if (insertarUsuario(usuario, email, contrasenia)) {
            mensajeLabel.setText("Usuario registrado con éxito.");
            System.out.println("Usuario registrado correctamente: " + usuario);
        } else {
            mensajeLabel.setText("Error al registrar el usuario.");
        }
    }

    /**
     * Metodo para verificar si un usuario ya esta registrado en la base de datos
     * 
     * @param usuario Nombre de usuario a verificar
     * @return true si el usuario ya existe, false en caso contrario
     */
    private boolean usuarioExiste(String usuario) {
        String sql = "SELECT usuario FROM usuarios WHERE LOWER(usuario) = LOWER(?)";

        try (Connection conn = ConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            System.out.println("Verificando usuario existente: " + usuario);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
            mensajeLabel.setText("Error al verificar el usuario.");
            return false;
        }
    }

    /**
     * Metodo para verificar si un email ya está registrado en la base de datos
     * 
     * @param email Correo electronico a verificar
     * @return true si el email ya existe, false en caso contrario
     */
    private boolean emailExiste(String email) {
        String sql = "SELECT email FROM usuarios WHERE LOWER(email) = LOWER(?)";

        try (Connection conn = ConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            System.out.println("Verificando email existente: " + email);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
            mensajeLabel.setText("Error al verificar el correo.");
            return false;
        }
    }

    /**
     * Metodo para insertar un nuevo usuario en la base de datos
     * 
     * @param usuario     Nombre de usuario
     * @param email       Correo electrónico
     * @param contrasenia Contraseña del usuario
     * @return true si el usuario fue insertado correctamente, false en caso
     *         contrario.
     */
    private boolean insertarUsuario(String usuario, String email, String contrasenia) {
        String sql = "INSERT INTO usuarios (usuario, email, contrasenia) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, email);
            stmt.setString(3, contrasenia);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            mensajeLabel.setText("Error al registrar el usuario.");
            return false;
        }
    }

    /**
     * Metodo para volver a la pantalla de login
     */
    @FXML
    private void goBack() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) goBackButton.getScene().getWindow();
            stage.setTitle("Inicio de Sesión");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
