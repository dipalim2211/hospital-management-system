package com.hospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

        try{
            //make connection with db
            Connection connection = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}
