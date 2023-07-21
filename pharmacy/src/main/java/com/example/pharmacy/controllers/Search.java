package com.example.pharmacy.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {

    @FXML
    private TableColumn<?, ?> searchEXPCol;

    @FXML
    private TableColumn<?, ?> searchFABCol;

    @FXML
    private TextField searchFieldtf;

    @FXML
    private TableColumn<?, ?> searchIDCol;

    @FXML
    private TableColumn<?, ?> searchNameCol;

    @FXML
    private TableColumn<?, ?> searchPriceCol;

    @FXML
    private TableColumn<?, ?> searchQtyCol;

    @FXML
    private TableColumn<?, ?> searchVendorCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
