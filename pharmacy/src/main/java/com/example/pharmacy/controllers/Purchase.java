package com.example.pharmacy.controllers;

import com.example.pharmacy.Data.DrugDataSource;
import com.example.pharmacy.Data.HistoryDataSource;
import com.example.pharmacy.Repository.Drug;
import com.example.pharmacy.Repository.History;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Purchase implements Initializable {

    @FXML
    private TextField drugBuyertf;

    @FXML
    private TextField drugIDtf;

    @FXML
    private TextField drugPricetf;

    @FXML
    private TextField drugPurchaseDatetf;

    @FXML
    private TextField drugPurchaseTimetf;

    @FXML
    private TextField drugQtytf;

    @FXML
    private Button savePurchaseBtn;

    @FXML
    void saveDetailsBtn(ActionEvent event) {
        if (event.getSource() == savePurchaseBtn) {
            pushToHistory();
            drugIDtf.clear();
            drugPricetf.clear();
            drugQtytf.clear();
            drugBuyertf.clear();
            drugPurchaseDatetf.clear();
            drugPurchaseTimetf.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void pushToHistory(){
        HistoryDataSource historyStack = new HistoryDataSource();
        int id = Integer.parseInt(drugIDtf.getText());
        String buyer = drugBuyertf.getText();
        int qty  = Integer.parseInt(drugQtytf.getText());
        String time = drugPurchaseTimetf.getText();
        Double price = Double.parseDouble(drugPricetf.getText());
        String date =drugPurchaseDatetf.getText();

        History history = new History(id, date, time, buyer, price, qty);
        historyStack.pushToHistory(history);
    }
}
