package com.example.springbootmvc.company;

import java.io.*;
import java.sql.*;

public class select_img {
    public static void main(String[] args) {
        try {
            Connection    connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/spring",
                    "javaDbUser","root");
            String sql="Select *  from attach where id=1;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                String name = resultSet.getString("name");
           //   InputStream inputStream= resultSet.getBinaryStream("data");
                File file = new File("storage/Без названия222.jpg");
                OutputStream outputStream = new FileOutputStream(file);
//           byte[] buffer =new byte[1024];
//           int read;
//           while ((read= inputStream.read(buffer))!=-1){
//               outputStream.write(buffer,0,read);
//           }
                byte[] data = resultSet.getBytes("data");
                outputStream.write(data);
                //outputStream.write(inputStream.readAllBytes());
        //   inputStream.close();
           outputStream.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
