package com.example.springbootmvc.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_table {
    public static void main(String[] args) {
        try{
            //Class.forName("otg.posrdresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/spring",
                    "javaDbUser","root");
     Statement st =connection.createStatement();
String sql ="create table if not exists Iroda( id serial primary key," +
        "name varchar(50), "+
        "data BYTEA , url varchar(255));";
st.execute(sql);
st.close();
connection.close();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
