package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Doctor {


    //Encapsulation
    private Connection connection;  //take value from main class

    private Scanner sc;

    //Parameterized constructor
    public Doctor(Connection connection, Scanner sc) {
        this.connection = connection;
        this.sc = sc;
    }

    // add doctors through db administration

    //Retrieve data from db and print
    public void viewDoctors(){

        String query = "select * from doctors";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            //data comes from database(sql) and stored in java local variable to display
            while(resultSet.next()){
                int id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt(3);
                String gender = resultSet.getString("gender");
                System.out.print(id+name+age+gender);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
