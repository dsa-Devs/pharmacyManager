module com.example.pharmacy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;


    opens com.example.pharmacy to javafx.fxml;
    opens com.example.pharmacy.controllers to javafx.fxml;
    exports com.example.pharmacy;


    exports com.example.pharmacy.Repository;
    opens com.example.pharmacy.Repository to javafx.fxml;

}