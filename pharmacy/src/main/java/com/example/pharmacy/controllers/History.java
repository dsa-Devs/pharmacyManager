package com.example.pharmacy.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class History implements Initializable {

    @FXML
    private TableColumn<?, ?> drugBuyerCol;

    @FXML
    private TableColumn<?, ?> drugIDCol;

    @FXML
    private TableColumn<?, ?> drugPurchaseDateCol;

    @FXML
    private TableColumn<?, ?> drugPurchaseTimeCol;

    @FXML
    private TableColumn<?, ?> drugQtyCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
