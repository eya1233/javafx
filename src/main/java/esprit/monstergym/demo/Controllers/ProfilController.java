package esprit.monstergym.demo.Controllers;

import esprit.monstergym.demo.Entities.User;
import esprit.monstergym.demo.Service.ResetPasswordService;
import esprit.monstergym.demo.Service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;


import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ProfilController implements Initializable {

    @FXML
    private VBox VBoxProfil;

    @FXML
    private Button btnBrowser;

    @FXML
    private Button btnModifProfil;

    @FXML
    private Button btnResetPass;

    @FXML
    private Label hello;

    @FXML
    private Label hello1;

    @FXML
    private Label hello11;

    @FXML
    private Label hello111;

    @FXML
    private Label hello1111;

    @FXML
    private Label hello11111;

    @FXML
    private Label hello1112;

    @FXML
    private Label hello2;

    @FXML
    private Label hello21;

    @FXML
    private ImageView imageView;

    @FXML
    private Label lbConfirmePasswordReset;

    @FXML
    private Label lbEmailProfil;

    @FXML
    private Label lbFullAddresseProfil;

    @FXML
    private Label lbFullNameProfil;

    @FXML
    private Label lbNumTelProfil;

    @FXML
    private Label lbPasswordReset;

    @FXML
    private Pane pane;

    @FXML
    private PasswordField tfConfirmPassword;

    @FXML
    private DatePicker tfDate;

    @FXML
    private TextField tfEmail;


    @FXML
    private TextField tfFullName;

    @FXML
    private TextField tfNumber;

    @FXML
    private PasswordField tfPassword;

    private FileChooser fileChooser;

    private File file;
    private Stage stage;

    private Image image_url;

    private UserService userService;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation de fileChooser
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All files","*.*"),
                new FileChooser.ExtensionFilter("Images","*.png","*.jpg","*.gif")
        );
        userService = UserService.getInstance();
        // Your existing initialization code...
        // Example usage:
        User authenticatedUser = userService.getAuthenticatedUser();
        tfEmail.setText(authenticatedUser.getEmail());
        tfDate.setValue(authenticatedUser.getDateNaissance().toLocalDate());
        tfNumber.setText(authenticatedUser.getNumero());
        tfFullName.setText(authenticatedUser.getUsername());
        if(authenticatedUser.getImageUrl() != null && !authenticatedUser.getImageUrl().equals("")){
            Image img = new Image(authenticatedUser.getImageUrl());
            imageView.setImage(img);
        }

        System.out.println("teqt"+authenticatedUser.toString());
    }


    @FXML
    void ResetPasswordAction(ActionEvent event) throws Exception {
        userService = UserService.getInstance();
        User authenticatedUser = userService.getAuthenticatedUser();
        ResetPasswordService rps = new ResetPasswordService();
        authenticatedUser.setPassword(tfPassword.getText());
        rps.ResetPassword(authenticatedUser);
        tfPassword.setText("");
        tfConfirmPassword.setText("");
        showUpdate("Password Updated succesfully");

    }

    @FXML
    void changeProfilAction(ActionEvent event) {
        userService = UserService.getInstance();
        // Your existing initialization code...
        // Example usage:
        User authenticatedUser = userService.getAuthenticatedUser();
        authenticatedUser.setEmail(tfEmail.getText());
        authenticatedUser.setNumero(tfNumber.getText());
        authenticatedUser.setUsername(tfFullName.getText());
        authenticatedUser.setDateNaissance(Date.valueOf(tfDate.getValue()));
        authenticatedUser.setImageUrl(imageView.getImage().getUrl());
        userService.update(authenticatedUser);
        showUpdate("user infos updated succesfully");
    }

    @FXML
    private void handleBrowser(ActionEvent event)  {
        if (fileChooser == null) {
            fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All files","*.*"),
                    new FileChooser.ExtensionFilter("Images","*.png","*.jpg","*.gif")
            );
        }
        stage = (Stage) pane.getScene().getWindow();
        file = fileChooser.showOpenDialog(stage);
        if(file != null){
            System.out.println(""+file.getAbsolutePath());
            image_url = new Image(file.getAbsoluteFile().toURI().toString(),imageView.getFitWidth(),imageView.getFitHeight(),true,true);
            imageView.setImage(image_url);
            imageView.setPreserveRatio(true);
        }
    }

    private void showUpdate(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setTitle("User Updated");
        alert.setHeaderText(null);
        alert.show();
    }
}
