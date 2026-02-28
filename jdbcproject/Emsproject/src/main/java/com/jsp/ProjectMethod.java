package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMethod {

    private static String url = "jdbc:postgresql://localhost:5432/emsproject";
    private static String user = "postgres";
    private static String pass = "Aman@9022";

    // --- ADMIN METHODS (ID-based) ---
    public void addEmployee(int id, String name, int age, String username) {
        String query = "INSERT INTO employee (id, name, age, username) VALUES (?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, username);
            ps.executeUpdate();
            System.out.println("Employee inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateEmployee(int id, String name, int age) {
        String query = "UPDATE employee SET name=?, age=? WHERE id=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee updated successfully");
            else System.out.println("Employee not found");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee deleted");
            else System.out.println("Employee not found");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchEmployee(int id) {
        String query = "SELECT * FROM employee WHERE id=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Username: " + rs.getString("username"));
            } else {
                System.out.println("Employee not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- EMPLOYEE METHODS (Username-based) ---
    public void fetchEmployeeByUsername(String username) {
        String query = "SELECT * FROM employee WHERE username=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Username: " + rs.getString("username"));
            } else {
                System.out.println("Employee record not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployeeByUsername(String username, String name, int age) {
        String query = "UPDATE employee SET name=?, age=? WHERE username=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, username);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Profile updated successfully");
            else System.out.println("Update failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
