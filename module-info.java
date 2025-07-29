module com.mycompany.apotek {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; 
    requires java.base;

    opens com.mycompany.apotek to javafx.fxml;
    exports com.mycompany.apotek;
}