package es.adrianroguez.controller;

import es.adrianroguez.controller.abstracts.AbstractController;
import es.adrianroguez.model.TaskModel;
import es.adrianroguez.model.Urgency;
import es.adrianroguez.session.Session;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class TaskInfoController extends AbstractController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField subtitleField;
    @FXML
    private ComboBox<String> urgencyBox;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private TextField creationDateField;
    @FXML
    private DatePicker dueDatePicker;

    @FXML
    public void initialize() {
        TaskModel task = Session.getSelectedTask();
        if (task != null) {
            titleField.setText(task.getTitle());
            subtitleField.setText(task.getSubtitle() != null ? task.getSubtitle() : "(Sin subtítulo)");
            descriptionArea.setText(task.getDescription() != null ? task.getDescription() : "(Sin descripción)");
            creationDateField
                    .setText(task.getCreationDate() != null ? task.getCreationDate().toString() : "(No definida)");
            dueDatePicker.setValue(task.getDueDate());

            if (task.getUrgency() != null) {
                urgencyBox.getItems().add(task.getUrgency().name());
                urgencyBox.getSelectionModel().selectFirst();
            }
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        cambiarPantalla(event, "/view/mainScreenView.fxml");
    }
}
