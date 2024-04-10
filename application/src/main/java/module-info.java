module assignment {
    requires javafx.controls;
    requires javafx.fxml;

    opens assignment to javafx.fxml;
    exports assignment;
}
