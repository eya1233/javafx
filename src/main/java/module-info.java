module esprit.monstergym.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens esprit.monstergym.demo.Controllers to javafx.fxml; // Add this line to open the Main package
    exports esprit.monstergym.demo;
    exports esprit.monstergym.demo.Controllers;
}
