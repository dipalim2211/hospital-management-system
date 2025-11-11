package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {

    /*
    private : no one can access beyond the class,provide security
    static : no need to create object while calling
    final : throughout program same value
     */

    private static final String url ="jdbc:mysql://localhost:3306/hospital";

    private static final String username = "root";

    private static final String password= "Java@2211";

    public static void main(String[] args) {
        try{
            //Load all driver required to connect database
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try{
            //make connection with db
            Connection connection = DriverManager.getConnection(url,username,password);
            Patient patient = new Patient(connection,scanner);
            Doctor doctor = new Doctor(connection);
            while (true){
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patients");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");

                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}
