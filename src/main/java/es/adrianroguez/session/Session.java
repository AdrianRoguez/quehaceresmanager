package es.adrianroguez.session;

import es.adrianroguez.model.TaskModel;
import es.adrianroguez.model.UserModel;

public class Session {
    private static UserModel currentUser;
    private static TaskModel selectedTask;

    /**
     * Establece el usuario actual para la sesion.
     * 
     * @param user El usuario que se quiere establecer como actual
     */
    public static void setCurrentUser(UserModel user) {
        currentUser = user;
    }

    /**
     * Obtiene el usuario actual de la sesion.
     * 
     * @return El usuario actual o null si no hay uno
     */
    public static UserModel getCurrentUser() {
        return currentUser;
    }

    // Tarea seleccionada
    public static void setSelectedTask(TaskModel task) {
        selectedTask = task;
    }

    public static TaskModel getSelectedTask() {
        return selectedTask;
    }

    /**
     * Limpia toda la sesion actual.
     */
    public static void clear() {
        currentUser = null;
        selectedTask = null;
    }
}
