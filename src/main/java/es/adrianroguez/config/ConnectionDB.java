package es.adrianroguez.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionDB {
    private String propertiesFile = "app.properties";
    private String urlDb;

    protected ConnectionDB() {
        try (InputStream inputStream = ConnectionDB.class.getClassLoader().getResourceAsStream(propertiesFile)) {
            Properties properties = new Properties();
            if (inputStream == null) {
                throw new IllegalArgumentException("El archivo de propiedades no es válido.");
            }
            properties.load(inputStream);
            urlDb = properties.getProperty("urlDb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + urlDb);
    }

    protected String getUrlDb() {
        return urlDb;
    }

}