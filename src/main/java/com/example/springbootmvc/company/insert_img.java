package com.example.springbootmvc.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class insert_img {
    public static void main(String[] args) {
File file = new File("Без названия.jpg");
        try {
            FileInputStream fis = new FileInputStream(file);
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/spring",
                    "javaDbUser","root");
            String sql="INSERT into Iroda(name,data,url)values(?,?,?)";
            PreparedStatement st =connection.prepareStatement(sql);
            st.setString(1,file.getName());
            st.setBinaryStream(2,fis);
            st.setString(3,file.getAbsolutePath());
st.executeUpdate();
connection.close();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
