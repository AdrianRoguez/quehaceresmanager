module es.adrianroguez.quehaceresmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.sql;

    opens es.adrianroguez to javafx.fxml;

    exports es.adrianroguez;
    exports es.adrianroguez.controllers;

    opens es.adrianroguez.controllers to javafx.fxml;
    opens es.adrianroguez.controllers.abstracts to javafx.fxml;
}
