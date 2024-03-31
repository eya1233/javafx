package esprit.monstergym.demo.Controllers;

import esprit.monstergym.demo.Entities.User;
import esprit.monstergym.demo.Service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class signInController implements Initializable {

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    private UserService userService;
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize UserService
        userService = new UserService();
        System.out.println("testtttttt");
    }

    @FXML
    void fnSignIn(ActionEvent event) {
        String email = tfEmail.getText();
        String password = tfPassword.getText();

        // Check if email and password are not empty
        if (validateFields(email, password)) {
            // Authenticate user
            User authenticatedUser = userService.authenticate(email, password);

            if (authenticatedUser != null) {
                try {
                    // Load the new page
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/esprit/monstergym/demo/hello-view.fxml"));
                    Parent root = loader.load();

                    // Pass the user to the HelloController
                    HelloController helloController = loader.getController();
                    System.out.println(authenticatedUser.toString());
                    helloController.setUser(authenticatedUser);

                    // Create a new stage for the new scene
                    Stage newStage = new Stage();
                    newStage.setScene(new Scene(root));
                    newStage.show();

                    // Close the current stage
                    Stage currentStage = (Stage) tfEmail.getScene().getWindow();
                    currentStage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Authentication failed, show error message
                showErrorAlert("Invalid email or password.");
            }
        } else {
            // Fields are empty, show error message
            showErrorAlert("Please enter email and password.");
        }
    }

    // Method to validate email and password fields
    private boolean validateFields(String email, String password) {
        return !email.isEmpty() && !password.isEmpty();
    }

    // Method to show error alert
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle("Authentication Failed");
        alert.setHeaderText(null);
        alert.show();
    }
}
