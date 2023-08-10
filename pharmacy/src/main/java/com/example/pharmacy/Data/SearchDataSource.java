package com.example.pharmacy.Data;

import com.example.pharmacy.DataBaseConnector.DatabaseConnection;
import com.example.pharmacy.Repository.Drug;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDataSource {

    public ObservableList<Drug> peekAtDatabase(String drugName){
        int id = 0, qty = 0;
        String name = " ", vendor = "", expDate ="", fabDate ="";
        Double unitPrice = 0.0;
        ObservableList<Drug> drugCollection = FXCollections.observableArrayList();

        String selectQuery = "SELECT * FROM drug where name = '" + drugName +"'";

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
                drugCollection.add(new Drug(id, name, qty, fabDate, expDate, vendor, unitPrice));
            }

            System.out.println("Stack.peek() operation performed on Database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return drugCollection;
    }
}
