package com.example.pharmacy.controllers;

import com.example.pharmacy.Data.HistoryDataSource;
import com.example.pharmacy.Repository.History;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Histories implements Initializable {

    @FXML
    private TableColumn<History, String > drugBuyerCol;

    @FXML
    private TableView<History> historyTableView;

    @FXML
    private TableColumn<History, Integer> drugIDCol;

    @FXML
    private TableColumn<History, Double> drugPriceCol;

    @FXML
    private TableColumn<History, String> drugPurchaseDateCol;

    @FXML
    private TableColumn<History, String> drugPurchaseTimeCol;

    @FXML
    private TableColumn<History, Integer> drugQtyCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        peeKAtHistory();
    }


    public void peeKAtHistory(){
        HistoryDataSource historyStack = new HistoryDataSource();
        ObservableList<History> historyCollection = historyStack.peekAtHistory();

        drugIDCol.setCellValueFactory(new PropertyValueFactory<>("drugID"));
        drugBuyerCol.setCellValueFactory(new PropertyValueFactory<>("buyer"));
        drugQtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        drugPurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        drugPurchaseTimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        drugPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        historyTableView.setItems(historyCollection);

    }


}
