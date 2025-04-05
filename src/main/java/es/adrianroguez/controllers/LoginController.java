package es.adrianroguez.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import es.adrianroguez.config.ConfigManager;
import es.adrianroguez.controllers.abstracts.AbstractController;
import es.adrianroguez.database.ConnectionDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends AbstractController {

    private final String pathIdioma = "src/main/resources/";
    private final String idiomaString = "idioma-";
    private final Map<String, String> idiomaCodigoMap = new HashMap<>();

    @FXML
    private Button registerButton;
    @FXML
    private ComboBox<String> idiomaComboBox;
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

    private static String usuarioActual;

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

    /**
     * Metodo para iniciar sesion
     */
    public void iniciarSesion() {
        String usuario = usuarioField.getText().trim();
        String contrasenia = contraseniaField.getText().trim();

        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            mensajeLabel.setText("Por favor, complete todos los campos.");
            return;
        }

        if (validarUsuario(usuario, contrasenia)) {
            setUsuarioActual(usuario);
            System.out.println("Usuario autenticado: " + usuarioActual);
            openMainScreen();
        } else {
            mensajeLabel.setText("Usuario o contraseña incorrectos.");
        }
    }

    /**
     * Metodo para validar las credenciales del usuario en la base de datos
     *
     * @param usuario     Nombre de usuario
     * @param contrasenia Contrasenia del usuario
     * @return true si las credenciales son correctas, false en caso contrario
     */
    private boolean validarUsuario(String usuario, String contrasenia) {
        String sql = "SELECT usuario FROM usuarios WHERE LOWER(usuario) = LOWER(?) AND contrasenia = ?";

        try (Connection conn = ConnectionDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, contrasenia);

            System.out.println("Ejecutando consulta: " + sql + " con usuario: " + usuario);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
            mensajeLabel.setText("Error al conectar con la base de datos.");
            return false;
        }
    }

    /**
     * Metodo para abrir la pantalla principal
     */
    private void openMainScreen() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main-screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setTitle("Pantalla Principal");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para abrir la ventana de registro
     */
    public void openRegister() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/register.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.setTitle("Pantalla Registro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para abrir la ventana de recuperación de contrasenia
     */
    public void openRememberPassword() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/rememberPassword.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) rememberPasswordButton.getScene().getWindow();
            stage.setTitle("Recuperar Contraseña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para almacenar el usuario autenticado
     *
     * @param usuario Nombre de usuario autenticado
     */
    public static void setUsuarioActual(String usuario) {
        usuarioActual = usuario;
    }

    /**
     * Metodo para obtener el usuario autenticado
     *
     * @return Nombre del usuario autenticado
     */
    public static String getUsuarioActual() {
        return usuarioActual;
    }
}
