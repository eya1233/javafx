module esprit.monstergym.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens esprit.monstergym.demo to javafx.fxml;
    exports esprit.monstergym.demo;

}