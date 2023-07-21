package com.example.pharmacy.controllers;

import com.example.pharmacy.Data.DatabaseStack;
import com.example.pharmacy.Repository.Drug;
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

public class Drugs  implements Initializable {

    @FXML
    private Button addDrugBtn;

    @FXML
    private TableColumn<Drug, String> drugEXPCol;

    @FXML
    private TextField drugEXPtf;

    @FXML
    private TableColumn<Drug, String> drugFABCol;

    @FXML
    private TextField drugFABtf;

    @FXML
    private TableColumn<Drug, Integer> drugIDCol;

    @FXML
    private TextField drugIDtf;

    @FXML
    private TableColumn<Drug, String> drugNameCol;

    @FXML
    private TextField drugNametf;

    @FXML
    private TableColumn<Drug, Double> drugPriceCol;

    @FXML
    private TextField drugPricetf;

    @FXML
    private TableColumn<Drug, Integer> drugQtyCol;

    @FXML
    private TextField drugQtytf;

    @FXML
    private TableView<Drug> drugTableView;

    @FXML
    private TableColumn<Drug, String> drugVendorCol;

    @FXML
    private TextField drugVendortf;


    @FXML
    private Button removeDrugtf;

    @FXML
    private void handleDrugBtn(ActionEvent event){
        pushToDatabase();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void pushToDatabase(){
        DatabaseStack databaseStack = new DatabaseStack();
        int id = Integer.parseInt(drugIDtf.getText());
        String name = drugNametf.getText();
        int qty  = Integer.parseInt(drugQtytf.getText());
        String vendor = drugVendortf.getText();
        String fabDate = drugFABtf.getText();
        String expDate =drugEXPtf.getText();
        double price = Double.parseDouble(drugPricetf.getText());

        Drug drug = new Drug(id, name, qty, vendor, fabDate, expDate, price);
        databaseStack.pushToDatabase(drug);
    }

    //public void peeKAtDatabase(){
       // DatabaseStack databaseStack = new DatabaseStack();

     //   drugIDCol.setCellFactory(new PropertyValueFactory<>("id"));

   //     drugTableView.getColumns().addAll(drugIDCol, drugNameCol, drugVendorCol,drugQtyCol,drugPriceCol,drugFABCol,drugEXPCol);


   // }

}
