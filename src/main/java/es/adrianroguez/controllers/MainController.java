package es.adrianroguez.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button usuarioButton;
    @FXML
    private Button desconectarseButton;
    @FXML
    private Button agregarButton;

    @FXML
    private void initialize() {
        
        usuarioButton.setOnAction(event -> System.out.println("Usuario presionado"));
        desconectarseButton.setOnAction(event -> System.out.println("Desconectarse presionado"));
        agregarButton.setOnAction(event -> System.out.println("Agregar (+) presionado"));
    }
}
