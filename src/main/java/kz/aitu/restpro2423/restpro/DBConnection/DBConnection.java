package kz.aitu.restpro2423.restpro.DBConnection;

import java.sql.*;

public class DBConnection {
    private String url = "jdbc:postgresql://localhost:5432/aitu2423";

    private String username = "postgres";

    private String password = "sunghoon123";

    public Connection connect() throws SQLException
    {
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully.");
        return con;
    }

    public int closeConnection(Connection con) throws SQLException
    {
        if (con != null)
        {
            con.close();
            System.out.println("Connection closed.");
            return 0;
        }
        System.out.println("Connection is already closed.");
        return 1;
    }
}