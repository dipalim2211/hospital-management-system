package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {


    //Encapsulation
    private Connection connection;  //take value from main class

    //Parameterized constructor
    public Doctor(Connection connection) {
        this.connection = connection;
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
                String specialization = resultSet.getString("specialization");

                System.out.print(id+name+specialization);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Retrieve doctors using ID

    public boolean getDoctorsById(int id){
        String query ="select * from patients where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
