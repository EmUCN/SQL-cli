package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static DBconnection instance = null;

    private Connection connection = null;

    String url = "";

    //"jdbc:sqlserver://localhost:1433;databaseName=mydatabase";
    private String baseUrl = "jdbc:sqlserver://";

    private String hostName = "";

    private String port = "";

    private String databaseName = "";

    private String userName = "";

    private String passWord = "";

    private DBconnection(String baseurl, String hostname, int port, String databaseName, String username, String password) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url = baseurl + hostname + ":" + port + ";databaseName=" + databaseName;
            connection = DriverManager.getConnection(url, username, password);
            this.userName = username;
            this.passWord = password;
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public static DBconnection getInstance(String baseurl, String hostname, int port, String databaseName, String username, String password) throws SQLException {
        if (instance == null) {
            instance = new DBconnection(baseurl, hostname, port, databaseName, username, password);
        } else if (!instance.url.equals(baseurl + hostname + ":" + port + ";databaseName=" + databaseName) || !instance.userName.equals(username) || !instance.passWord.equals(password) || instance.getConnection().isClosed()) {
            instance.connection.close();
            instance = new DBconnection(baseurl, hostname, port, databaseName, username, password);
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}