package es.adrianroguez.model;

import java.time.LocalDate;
import java.util.Objects;

public class TaskModel {
    private int id;
    private int userId;
    private String title;
    private String subtitle;
    private Urgency urgency;
    private String description;
    private LocalDate creationDate;
    private LocalDate dueDate;

    /**
     * Constructor vacio.
     */
    public TaskModel() {
    }

    /**
     * Constructor por defecto.
     * 
     * @param id
     * @param userId
     * @param title
     * @param subtitle
     * @param urgency
     * @param description
     * @param creationDate
     * @param dueDate
     */
    public TaskModel(int id, int userId, String title, String subtitle, Urgency urgency, String description,
            LocalDate creationDate, LocalDate dueDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.subtitle = subtitle;
        this.urgency = urgency;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    /**
     * Constructor sin id de TaskModel.
     * 
     * @param userId
     * @param title
     * @param subtitle
     * @param urgency
     * @param description
     * @param creationDate
     * @param dueDate
     */
    public TaskModel(int userId, String title, String subtitle, Urgency urgency, String description,
            LocalDate creationDate, LocalDate dueDate) {
        this.userId = userId;
        this.title = title;
        this.subtitle = subtitle;
        this.urgency = urgency;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Urgency getUrgency() {
        return this.urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskModel id(int id) {
        setId(id);
        return this;
    }

    public TaskModel userId(int userId) {
        setUserId(userId);
        return this;
    }

    public TaskModel title(String title) {
        setTitle(title);
        return this;
    }

    public TaskModel subtitle(String subtitle) {
        setSubtitle(subtitle);
        return this;
    }

    public TaskModel urgency(Urgency urgency) {
        setUrgency(urgency);
        return this;
    }

    public TaskModel description(String description) {
        setDescription(description);
        return this;
    }

    public TaskModel creationDate(LocalDate creationDate) {
        setCreationDate(creationDate);
        return this;
    }

    public TaskModel dueDate(LocalDate dueDate) {
        setDueDate(dueDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskModel)) {
            return false;
        }
        TaskModel taskModel = (TaskModel) o;
        return id == taskModel.id && userId == taskModel.userId && Objects.equals(title, taskModel.title)
                && Objects.equals(subtitle, taskModel.subtitle) && Objects.equals(urgency, taskModel.urgency)
                && Objects.equals(description, taskModel.description)
                && Objects.equals(creationDate, taskModel.creationDate) && Objects.equals(dueDate, taskModel.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, subtitle, urgency, description, creationDate, dueDate);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", title='" + getTitle() + "'" +
                ", subtitle='" + getSubtitle() + "'" +
                ", urgency='" + getUrgency() + "'" +
                ", description='" + getDescription() + "'" +
                ", creationDate='" + getCreationDate() + "'" +
                ", dueDate='" + getDueDate() + "'" +
                "}";
    }

}
