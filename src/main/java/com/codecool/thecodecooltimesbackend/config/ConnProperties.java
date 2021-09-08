package com.codecool.thecodecooltimesbackend.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class ConnProperties {

    private static String SERVER;
    private static String DATABASE;
    private static String USER;
    private static String PASSWORD;

    static {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "connection.properties";
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(appConfigPath));
            SERVER = p.getProperty("server", null);
            DATABASE = p.getProperty("database", null);
            USER = p.getProperty("user", null);
            PASSWORD = p.getProperty("password", null);
        } catch (IOException e) {
            System.out.println("'connection.properties' not found!");
        }
    }

    public static DataSource getDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName(SERVER);
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        try {
            dataSource.getConnection().close();
            System.out.println("Database connection successful, loading products from database");
            return dataSource;
        } catch (SQLException e) {
            System.out.println("Database connection failed, loading products from memory");
            return null;
        }
    }
}

