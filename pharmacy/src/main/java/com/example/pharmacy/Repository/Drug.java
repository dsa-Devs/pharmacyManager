package com.example.pharmacy.Repository;

public class Drug {
    private int id;
    private  String name;
    private int qty;
    private String vendor;
    private String fabDate;
    private String expDate;
    private Double unitPrice;


    public Drug(int id, String name, int qty, String vendor, String fabDate, String expDate, Double unitPrice) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.vendor = vendor;
        this.fabDate = fabDate;
        this.expDate = expDate;
        this.unitPrice = unitPrice;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getFabDate() {
        return fabDate;
    }

    public void setFabDate(String fabDate) {
        this.fabDate = fabDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
