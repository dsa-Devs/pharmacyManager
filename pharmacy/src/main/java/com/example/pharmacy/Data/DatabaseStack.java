package com.example.pharmacy.Data;

import com.example.pharmacy.DataBaseConnector.DatabaseConnection;
import com.example.pharmacy.Repository.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseStack {

    public void pushToDatabase(Drug drug){
        String connectionQuery = "INSERT INTO drug (id, name, qty, fabDate, expDate, vendor, unitPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            PreparedStatement statement = connectDB.prepareStatement(connectionQuery);
            statement.setInt(1, drug.getId());
            statement.setString(2, drug.getName());
            statement.setInt(3,drug.getQty());
            statement.setString(4, drug.getFabDate());
            statement.setString(5, drug.getExpDate());
            statement.setString(6, drug.getVendor());
            statement.setDouble(7, drug.getUnitPrice());
            statement.executeUpdate();

            System.out.println("Stack.push() operation performed on Database" + drug.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Drug peekAtDatabase(){
        int id = 0, qty = 0;
        String name = " ", vendor = "", expDate ="", fabDate ="";
        Double unitPrice = 0.0;

        String selectQuery = "SELECT * FROM drug";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            PreparedStatement statement = connectDB.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                 id = resultSet.getInt("id");
                 name = resultSet.getString("name");
                 qty = resultSet.getInt("qty");
                 fabDate = resultSet.getString("fabDate");
                 expDate = resultSet.getString("expDate");
                 vendor = resultSet.getString("vendor");
                 unitPrice = resultSet.getDouble("unitPrice");

            }

            System.out.println("Stack.peek() operation performed on Database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  new Drug(id,  name, qty,vendor, fabDate, expDate, unitPrice);
    }



    public Drug popFromDatabase(){
        int id = 0, qty = 0;
        String name = "", fabDate = "", expDate = "", vendor = "";
        Double unitPrice = 0.0;

        String selectQuery = "SELECT * FROM drug";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            PreparedStatement statement = connectDB.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                 id = resultSet.getInt("id");
                 name = resultSet.getString("name");
                 qty = resultSet.getInt("qty");
                 fabDate = resultSet.getString("fabDate");
                 expDate = resultSet.getString("expDate");
                 vendor = resultSet.getString("vendor");
                 unitPrice = resultSet.getDouble("unitPrice");

            }
            String deleteQuery =  "DELETE FROM drugs WHERE id = ?";

            try{
                PreparedStatement delStatement = connectDB.prepareStatement(deleteQuery);
                statement.setInt(1, id);
                System.out.println("Stack.pop() operation performed on Database");
                System.out.println("Drug instance returned.");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  new Drug(id, name, qty, vendor, fabDate, expDate, unitPrice);
    }

}
