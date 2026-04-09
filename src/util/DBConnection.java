package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author GymTracker
 * @version 1.0
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gym_tracker";
    private static final String USER = "root";
    private static final String PASSWORD = "cst4";
    private static DBConnection instance;

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the singleton instance.
     * @return DBConnection instance
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    /**
     * Get a connection to the database.
     * To change credentials, modify the USER and PASSWORD constants in this class.
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        getInstance();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
