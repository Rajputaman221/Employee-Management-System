package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class validation {

    private static String url = "jdbc:postgresql://localhost:5432/emsproject";
    private static String user = "postgres";
    private static String pass = "Aman@9022";

    public boolean isAdminPresent(String username, String password) {
        String query = "SELECT 1 FROM login WHERE username=? AND password=? AND type='admin'";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isEmployeePresent(String username, String password) {
        String query = "SELECT 1 FROM login WHERE username=? AND password=? AND type='employee'";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
