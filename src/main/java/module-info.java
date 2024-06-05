module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;
    requires commons.csv;

    opens br.edu.ifsp to javafx.fxml;
    exports br.edu.ifsp;
}
