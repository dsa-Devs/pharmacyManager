package com.example.pharmacy.Repository;

public class History {
    private int drugID;
    private String date;
    private String time;
    private String buyer;
    private double price;
    private int qty;

    public History(int drugID, String date, String time, String buyer, double price, int qty) {
        this.drugID = drugID;
        this.date = date;
        this.time = time;
        this.buyer = buyer;
        this.price = price;
        this.qty = qty;
    }

    public int getDrugID() {
        return drugID;
    }

    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}