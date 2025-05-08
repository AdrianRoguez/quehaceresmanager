package es.adrianroguez.service;

import es.adrianroguez.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws Exception {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        userService = spy(new UserService());
        doReturn(mockConnection).when(userService).connect();
    }

    @Test
    public void testCreateUserSuccess() throws Exception {
        UserModel user = new UserModel("testuser", "test@example.com", "password");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = userService.createUser(user);

        assertTrue(result);
        verify(mockPreparedStatement).setString(1, "testuser");
        verify(mockPreparedStatement).setString(2, "test@example.com");
        verify(mockPreparedStatement).setString(3, "password");
    }

    @Test
    public void testDeleteUserSuccess() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = userService.deleteUser(1);

        assertTrue(result);
        verify(mockPreparedStatement).setInt(1, 1);
    }

    @Test
    public void testUpdateUserSuccess() throws Exception {
        UserModel user = new UserModel(1, "updated", "updated@example.com", "newpass");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = userService.updateUser(user);

        assertTrue(result);
    }

    @Test
    public void testValidateCredentialsSuccess() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);

        boolean result = userService.validateCredentials("user", "pass");

        assertTrue(result);
    }

    @Test
    public void testUserExistsByEmailTrue() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);

        boolean result = userService.userExistsByEmail("user@example.com");

        assertTrue(result);
    }

    @Test
    public void testGetAllUsersEmpty() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        List<UserModel> result = userService.getAllUsers();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetUserByIdFound() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("username")).thenReturn("user");
        when(mockResultSet.getString("email")).thenReturn("user@example.com");
        when(mockResultSet.getString("password")).thenReturn("pass");

        UserModel user = userService.getUserById(1);

        assertNotNull(user);
        assertEquals("user", user.getUsername());
    }

    @Test
    public void testGetUserByCredentialsFound() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("username")).thenReturn("user");
        when(mockResultSet.getString("email")).thenReturn("user@example.com");
        when(mockResultSet.getString("password")).thenReturn("pass");

        UserModel user = userService.getUserByCredentials("user", "pass");

        assertNotNull(user);
        assertEquals("user", user.getUsername());
    }
}