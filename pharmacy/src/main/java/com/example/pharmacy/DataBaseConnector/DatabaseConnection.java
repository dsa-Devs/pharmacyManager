package com.example.pharmacy.DataBaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
 public Connection dataBaseLink;

 public  Connection getConnection(){
  String databaseName = "pharmacy";
  String databaseUser = "root";
  String databasePassword = "@WarlordAfrica12";
  String url = "jdbc:mysql://localhost:3306/" + databaseName;


  try{
   Class.forName("com.mysql.cj.jdbc.Driver");
   dataBaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
  }
   catch (Exception e){
   e.printStackTrace();
  }

  return dataBaseLink;
 }
}
