package com.jsp;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        validation login = new validation();
        ProjectMethod emp = new ProjectMethod();

        System.out.println("Login as");
        System.out.println("1. Admin");
        System.out.println("2. Employee");

        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.println("Username:");
        String username = sc.nextLine();

        System.out.println("Password:");
        String pwd = sc.nextLine();

        // --- ADMIN LOGIN ---
        if (choice == 1) {
            if (login.isAdminPresent(username, pwd)) {
                System.out.println("Admin login successful");
                while (true) {
                    System.out.println("\n1.Insert Employee");
                    System.out.println("2.Update Employee");
                    System.out.println("3.Delete Employee");
                    System.out.println("4.Fetch Employee");
                    System.out.println("5.Exit");

                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {
                        case 1:
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Age: ");
                            int age = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Username: ");
                            String uname = sc.nextLine();
                            emp.addEmployee(id, name, age, uname);
                            break;
                        case 2:
                            System.out.print("Enter ID: ");
                            int uid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter New Age: ");
                            int newAge = sc.nextInt();
                            emp.updateEmployee(uid, newName, newAge);
                            break;
                        case 3:
                            System.out.print("Enter Employee ID: ");
                            emp.deleteEmployee(sc.nextInt());
                            break;
                        case 4:
                            System.out.print("Enter Employee ID: ");
                            emp.fetchEmployee(sc.nextInt());
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            } else {
                System.out.println("Invalid admin login");
            }
        }

        // --- EMPLOYEE LOGIN ---
        else if (choice == 2) {
            if (login.isEmployeePresent(username, pwd)) {
                System.out.println("Employee login successful");
                while (true) {
                    System.out.println("\n1.View My Profile");
                    System.out.println("2.Update My Profile");
                    System.out.println("3.Exit");

                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {
                        case 1:
                            emp.fetchEmployeeByUsername(username);
                            break;
                        case 2:
                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter New Age: ");
                            int newAge = sc.nextInt();
                            emp.updateEmployeeByUsername(username, newName, newAge);
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            } else {
                System.out.println("Invalid employee login");
            }
        } else {
            System.out.println("Invalid choice");
        }
        sc.close();
    }
}
