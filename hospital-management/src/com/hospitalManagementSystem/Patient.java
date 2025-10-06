package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {

    private Connection connection;

    private Scanner sc;

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

        try{
        String query ="Insert into ";
        }catch (SQLException e){
        e.printStackTrace();
        }
    }

}
