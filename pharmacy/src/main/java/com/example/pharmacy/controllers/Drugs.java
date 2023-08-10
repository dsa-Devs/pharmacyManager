package com.example.pharmacy.controllers;

import com.example.pharmacy.Data.DrugDataSource;
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
    private Button removeDrugBtn;

    @FXML
    private void handleDrugBtn(ActionEvent event){
        if (event.getSource() == addDrugBtn) {
            pushToDatabase();
            peeKAtDatabase();
            drugIDtf.clear();
            drugNametf.clear();
            drugQtytf.clear();
            drugVendortf.clear();
            drugFABtf.clear();
            drugEXPtf.clear();
            drugPricetf.clear();
        } else if(event.getSource() == removeDrugBtn){
            popFromDatabase();
            peeKAtDatabase();
            drugIDtf.clear();
            drugNametf.clear();
            drugQtytf.clear();
            drugVendortf.clear();
            drugFABtf.clear();
            drugEXPtf.clear();
            drugPricetf.clear();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    peeKAtDatabase();
    }

    public void pushToDatabase(){
        DrugDataSource databaseStack = new DrugDataSource();
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

    public void peeKAtDatabase(){
       DrugDataSource databaseStack = new DrugDataSource();
        ObservableList<Drug> drugCollection = databaseStack.peekAtDatabase();

        drugIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        drugNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        drugQtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        drugVendorCol.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        drugFABCol.setCellValueFactory(new PropertyValueFactory<>("fabDate"));
        drugEXPCol.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        drugPriceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        drugTableView.setItems(drugCollection);

   }


    public void popFromDatabase(){
        DrugDataSource databaseStack = new DrugDataSource();
        int id = Integer.parseInt(drugIDtf.getText());
        String name = drugNametf.getText();
        int qty  = Integer.parseInt(drugQtytf.getText());
        String vendor = drugVendortf.getText();
        String fabDate = drugFABtf.getText();
        String expDate =drugEXPtf.getText();
        double price = Double.parseDouble(drugPricetf.getText());

        Drug drug = new Drug(id, name, qty, vendor, fabDate, expDate, price);
        databaseStack.popFromDatabase(drug);
    }


}
