package es.adrianroguez.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.adrianroguez.config.ConnectionDB;
import es.adrianroguez.model.TaskModel;
import es.adrianroguez.model.Urgency;

public class TaskService extends ConnectionDB {
    public boolean createTask(TaskModel taskModel) {
        String sql = "INSERT INTO tasks (user_id, title, subtitle, urgency, description, creation_date, due_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, taskModel.getUserId());
            preparedStatement.setString(2, taskModel.getTitle());
            preparedStatement.setString(3, taskModel.getSubtitle());
            preparedStatement.setString(4, taskModel.getUrgency().name());
            preparedStatement.setString(5, taskModel.getDescription());
            preparedStatement.setDate(6, Date.valueOf(taskModel.getCreationDate()));
            preparedStatement.setDate(7, Date.valueOf(taskModel.getDueDate()));
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTask(TaskModel taskModel) {
        String sql = "UPDATE tasks SET title = ?, subtitle = ?, urgency = ?, description = ?, creation_date = ?, due_date = ? WHERE id = ?";
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, taskModel.getTitle());
            preparedStatement.setString(2, taskModel.getSubtitle());
            preparedStatement.setString(3, taskModel.getUrgency().name());
            preparedStatement.setString(4, taskModel.getDescription());
            preparedStatement.setDate(5, Date.valueOf(taskModel.getCreationDate()));
            preparedStatement.setDate(6, Date.valueOf(taskModel.getDueDate()));
            preparedStatement.setInt(7, taskModel.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<TaskModel> getAllTasks() {
        List<TaskModel> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                tasks.add(new TaskModel(resultSet.getInt("id"), resultSet.getInt("user_id"),
                        resultSet.getString("title"), resultSet.getString("subtitle"),
                        Urgency.valueOf(resultSet.getString("urgency")), resultSet.getString("description"),
                        resultSet.getDate("creation_date").toLocalDate(), resultSet.getDate("due_date").toLocalDate()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public TaskModel getTaskById(int id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new TaskModel(resultSet.getInt("id"), resultSet.getInt("user_id"),
                        resultSet.getString("title"), resultSet.getString("subtitle"),
                        Urgency.valueOf(resultSet.getString("urgency")), resultSet.getString("description"),
                        resultSet.getDate("creation_date").toLocalDate(), resultSet.getDate("due_date").toLocalDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TaskModel> getTasksByUserId(int userId) {
        List<TaskModel> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE user_id = ?";
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new TaskModel(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("subtitle"),
                        Urgency.valueOf(resultSet.getString("urgency")),
                        resultSet.getString("description"),
                        resultSet.getDate("creation_date").toLocalDate(),
                        resultSet.getDate("due_date").toLocalDate()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

}