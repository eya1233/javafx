module esprit.monstergym.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires jbcrypt;


    requires AnimateFX;
    requires de.jensd.fx.glyphs.fontawesome;
    requires mail;
    requires org.apache.pdfbox;


    opens esprit.monstergym.demo.Controllers to javafx.fxml; // Add this line to open the Main package
    exports esprit.monstergym.demo;
    exports esprit.monstergym.demo.Controllers;
    exports esprit.monstergym.demo.Entities; // Ajoutez cette ligne pour exporter le package Entities
    exports esprit.monstergym.demo.Service;

}
