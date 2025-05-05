package es.adrianroguez.controller;

import java.time.LocalDate;

import es.adrianroguez.controller.abstracts.AbstractController;
import es.adrianroguez.model.TaskModel;
import es.adrianroguez.model.Urgency;
import es.adrianroguez.service.TaskService;
import es.adrianroguez.session.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateTaskController extends AbstractController {
    @FXML
    private Button goBackButton;
    @FXML
    private ComboBox<Urgency> urgencyBox;
    @FXML
    private TextField titleField;
    @FXML
    private TextField subtitleField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private DatePicker dueDatePicker;
    @FXML
    private Text mensajeLabel;

    private TaskService taskService = new TaskService();

    @FXML
    private void initialize() {
        urgencyBox.getItems().setAll(Urgency.values());
    }

    @FXML
    private void createTask(ActionEvent event) {
        String title = titleField.getText();
        String subtitle = subtitleField.getText();
        String description = descriptionArea.getText();
        Urgency urgency = urgencyBox.getValue();
        LocalDate dueDate = dueDatePicker.getValue();
        LocalDate creationDate = LocalDate.now();

        if (title == null || title.isBlank() || urgency == null || dueDate == null) {
            mensajeLabel.setText("Título, urgencia y fecha de entrega son obligatorios.");
            return;
        }

        int userId = Session.getCurrentUser().getId();

        TaskModel task = new TaskModel(
                userId,
                title,
                subtitle,
                urgency,
                description,
                creationDate,
                dueDate);

        boolean success = taskService.createTask(task);
        if (success) {
            System.out.println("Tarea creada correctamente.");
            goBack(event);

        } else {
            mensajeLabel.setText("Hubo un error al crear la tarea.");
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        cambiarPantalla(event, "/view/mainScreenView.fxml");
    }
}
