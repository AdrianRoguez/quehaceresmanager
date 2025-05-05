package es.adrianroguez.controller;

import java.util.List;

import es.adrianroguez.config.ConfigManager;
import es.adrianroguez.controller.abstracts.AbstractController;
import es.adrianroguez.model.TaskModel;
import es.adrianroguez.service.TaskService;
import es.adrianroguez.session.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class MainScreenController extends AbstractController {
    @FXML
    private Button userButton;
    @FXML
    private ListView<TaskModel> taskListView;
    @FXML
    private Button desconectarseButton;
    @FXML
    private Button agregarButton;

    private final TaskService taskService = new TaskService();

    @FXML
    public void initialize() {
        cambiarIdioma();
        cargarTareasDelUsuario();
    }

    public void cambiarIdioma() {
        userButton.setText(ConfigManager.ConfigProperties.getProperty("userButton"));
        desconectarseButton.setText(ConfigManager.ConfigProperties.getProperty("desconectarseButton"));
    }

    private void cargarTareasDelUsuario() {
        if (Session.getCurrentUser() != null) {
            List<TaskModel> tareas = taskService.getTasksByUserId(Session.getCurrentUser().getId());
            ObservableList<TaskModel> tareasObservable = FXCollections.observableArrayList(tareas);
            taskListView.setItems(tareasObservable);

            taskListView.setCellFactory(listView -> new ListCell<>() {
                @Override
                protected void updateItem(TaskModel task, boolean empty) {
                    super.updateItem(task, empty);
                    if (empty || task == null) {
                        setText(null);
                    } else {
                        setText(task.getTitle() + " | " + task.getUrgency().name() + " | "
                                + task.getDueDate());
                    }
                }
            });

            taskListView.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && taskListView.getSelectionModel().getSelectedItem() != null) {
                    TaskModel selectedTask = taskListView.getSelectionModel().getSelectedItem();
                    Session.setSelectedTask(selectedTask);
                    cambiarPantalla(new ActionEvent(event.getSource(), null), "/view/taskInfoView.fxml");
                }
            });
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        cambiarPantalla(event, "/view/loginView.fxml");
    }

    @FXML
    private void goCreateTask(ActionEvent event) {
        cambiarPantalla(event, "/view/createTaskView.fxml");
    }

    /**
     * Metodo para abrir la ventana de user.
     */
    public void openUser(ActionEvent event) {
        cambiarPantalla(event, "/view/userView.fxml");
    }
}
