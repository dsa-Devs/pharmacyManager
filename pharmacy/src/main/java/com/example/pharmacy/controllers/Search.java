package com.example.pharmacy.controllers;


import com.example.pharmacy.Data.DrugDataSource;
import com.example.pharmacy.Data.SearchDataSource;
import com.example.pharmacy.Repository.Drug;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {

    @FXML
    private TableColumn<Drug, String> searchEXPCol;

    @FXML
    private TableColumn<Drug, String> searchFABCol;

    @FXML
    private TextField searchFieldtf;

    @FXML
    private TableColumn<Drug, Integer> searchIDCol;

    @FXML
    private TableColumn<Drug, String> searchNameCol;

    @FXML
    private TableColumn<Drug, Double> searchPriceCol;

    @FXML
    private TableColumn<Drug, Integer> searchQtyCol;

    @FXML
    private TableColumn<Drug, String> searchVendorCol;

    @FXML
    private Button searchBtn;


    @FXML
    void handleSearch(ActionEvent event) {
        if (event.getSource() == searchBtn){
            peeKAtDatabase();
            searchFieldtf.clear();
        }
    }
    @FXML
    private TableView<Drug> searchTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void peeKAtDatabase(){
        SearchDataSource searchSource = new SearchDataSource();
        ObservableList<Drug> drugCollection = searchSource.peekAtDatabase(searchFieldtf.getText());

        searchIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        searchNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        searchQtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        searchVendorCol.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        searchFABCol.setCellValueFactory(new PropertyValueFactory<>("fabDate"));
        searchEXPCol.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        searchPriceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        searchTableView.setItems(drugCollection);

    }

}
