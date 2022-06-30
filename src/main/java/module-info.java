module com.example.semafor_zadanie_morong {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.semafor_zadanie_morong to javafx.fxml;
    exports com.example.semafor_zadanie_morong;
}