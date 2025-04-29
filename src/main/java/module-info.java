module org.example.ca2_dsa2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ca2_dsa2 to javafx.fxml;
    exports org.example.ca2_dsa2;
}