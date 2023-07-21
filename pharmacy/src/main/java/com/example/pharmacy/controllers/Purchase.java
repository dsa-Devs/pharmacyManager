package com.example.pharmacy.controllers;

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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
