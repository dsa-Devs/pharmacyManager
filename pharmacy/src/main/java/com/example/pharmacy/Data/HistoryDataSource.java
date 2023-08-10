package com.example.pharmacy.Data;

import com.example.pharmacy.DataBaseConnector.DatabaseConnection;
import com.example.pharmacy.Repository.Drug;
import com.example.pharmacy.Repository.History;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryDataSource {

    public void pushToHistory(History history){
        String connectionQuery = "INSERT INTO history (drug_id, time, date, buyer, price, qty) VALUES (?, ?, ?, ?, ?, ?)";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            PreparedStatement statement = connectDB.prepareStatement(connectionQuery);
            statement.setInt(1, history.getDrugID());
            statement.setString(2, history.getTime());
            statement.setString(3,history.getDate());
            statement.setString(4, history.getBuyer());
            statement.setDouble(5, history.getPrice());
            statement.setInt(6, history.getQty());
            statement.executeUpdate();

            System.out.println("Stack.push() operation performed on Database" + history.getDrugID());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ObservableList<History> peekAtHistory(){
        int id = 0, qty = 0;
        String date = " ", buyer = "", time ="";
        Double price = 0.00;
        ObservableList<History> historyCollection = FXCollections.observableArrayList();

        String selectQuery = "SELECT * FROM history";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            PreparedStatement statement = connectDB.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                id = resultSet.getInt("drug_id");
                time = resultSet.getString("time");
                date = resultSet.getString("date");
                buyer = resultSet.getString("buyer");
                price = resultSet.getDouble("price");
                qty = resultSet.getInt("qty");

                historyCollection.add(new History(id, date, time, buyer, price, qty));
            }

            System.out.println("Stack.peek() operation performed on Database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return historyCollection;
    }
}

