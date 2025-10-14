package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {

    //Encapsulation
    private Connection connection;  //take value from main class

    private Scanner sc;

    //Parameterized constructor
    public Patient(Connection connection, Scanner sc) {
        this.connection = connection;
        this.sc = sc;
    }

    public void addPatient(){
        System.out.print("Enter Patient Name : ");
        String name = sc.next();

        System.out.println("Age : ");
        int age= sc.nextInt();

        System.out.println("Gender :  ");
        String gender = sc.next();

        //try-catch : to avoid sql exception while connecting to db using connection Interface

        try{
            String query = "Insert into patients(name,age,gender)values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);
            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("Patient Added Successfully");
            }else
                System.out.println("Failed to add patient");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
