package es.adrianroguez.service;

import es.adrianroguez.model.TaskModel;
import es.adrianroguez.model.Urgency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    private TaskService taskService;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws Exception {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        taskService = spy(new TaskService());
        doReturn(mockConnection).when(taskService).connect();
    }

    @Test
    public void testCreateTaskSuccess() throws Exception {
        TaskModel task = new TaskModel(1, "Title", "Subtitle", Urgency.ALTA, "Desc", LocalDate.now(),
                LocalDate.now().plusDays(1));

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = taskService.createTask(task);

        assertTrue(result);
        verify(mockPreparedStatement).setInt(eq(1), eq(1));
        verify(mockPreparedStatement).setString(eq(2), eq("Title"));
    }

    @Test
    public void testDeleteTaskSuccess() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = taskService.deleteTask(1);

        assertTrue(result);
        verify(mockPreparedStatement).setInt(1, 1);
    }

    @Test
    public void testUpdateTaskSuccess() throws Exception {
        TaskModel task = new TaskModel(10, 1, "Updated", "Sub", Urgency.MEDIA, "Text", LocalDate.now(),
                LocalDate.now().plusDays(2));

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = taskService.updateTask(task);

        assertTrue(result);
        verify(mockPreparedStatement).setString(1, "Updated");
    }

    @Test
    public void testGetAllTasksEmpty() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        List<TaskModel> tasks = taskService.getAllTasks();

        assertNotNull(tasks);
        assertEquals(0, tasks.size());
    }

    @Test
    public void testGetTaskByIdFound() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getInt("user_id")).thenReturn(2);
        when(mockResultSet.getString("title")).thenReturn("Task");
        when(mockResultSet.getString("subtitle")).thenReturn("Sub");
        when(mockResultSet.getString("urgency")).thenReturn("BAJA");
        when(mockResultSet.getString("description")).thenReturn("Desc");
        when(mockResultSet.getDate("creation_date")).thenReturn(Date.valueOf(LocalDate.now()));
        when(mockResultSet.getDate("due_date")).thenReturn(Date.valueOf(LocalDate.now().plusDays(1)));

        TaskModel task = taskService.getTaskById(1);

        assertNotNull(task);
        assertEquals("Task", task.getTitle());
        assertEquals(Urgency.BAJA, task.getUrgency());
    }

    @Test
    public void testGetTasksByUserIdEmpty() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        List<TaskModel> tasks = taskService.getTasksByUserId(999);

        assertNotNull(tasks);
        assertEquals(0, tasks.size());
    }
}