package esprit.monstergym.demo.Controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import esprit.monstergym.demo.Entities.User;
import esprit.monstergym.demo.Service.UserService;
import esprit.monstergym.demo.Utils.ConnectionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.util.Callback;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.input.MouseEvent;
import java.util.Optional;




public class AffichageUsersController {

    @FXML
    private VBox VBoxShowUsers;

    @FXML
    private TableColumn<User, Integer> numeroCol;

    @FXML
    private TableColumn<User, String> usernameCol;

    @FXML
    private TableColumn<User, String> emailCol;

    @FXML
    private TableColumn<User, String> etatCol;

    @FXML
    private TableColumn<User, Boolean> isVerifiedCol;
    @FXML
    private TableColumn<User, Date> dateCol;

    @FXML
    private TableView<User> tableViewUsers;

    @FXML
    private TableColumn<User, String> actionsCol;

    ObservableList<User> userList = FXCollections.observableArrayList();

    Button btnBLock = null;


    @FXML
    void Select(ActionEvent event) {

    }

    @FXML
    void handleChart(ActionEvent event) {

    }

    @FXML
    void handleSaveFile(ActionEvent event) {

    }

    @FXML
    private void initialize() {
        // Associer les colonnes du tableau aux propriétés de l'objet User
        numeroCol.setCellValueFactory(new PropertyValueFactory<>("numero"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        etatCol.setCellValueFactory(new PropertyValueFactory<>("etat"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        isVerifiedCol.setCellValueFactory(new PropertyValueFactory<>("is_verified"));

        // Charger les données depuis la base de données et les afficher dans le tableau
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        UserService us = new UserService();
        for(int i=  0 ; i<us.getAll().size();i++){
            System.out.println(us.getAll().get(i).toString());
            tableViewUsers.getItems().add(us.getAll().get(i));
        }
    }

    private void refrachListClck() {
        userList.clear();

        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM `user` WHERE id != 1";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    // Récupération de l'état de vérification de l'utilisateur
                    String verificationStatus = resultSet.getInt("is_verified") == 1 ? "Compte Verified" : "Compte non Verified";

                    // Création du bouton d'état de blocage
                    Button blockButton = new Button();
                    String etat;
                    if (!resultSet.getBoolean("etat")) {
                        blockButton.setText("Blocked");
                        blockButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
                        etat = "Blocked";
                    } else {
                        blockButton.setText("Deblocked");
                        blockButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                        etat = "Deblocked";
                    }

                    // Ajout de l'utilisateur à la liste des utilisateurs
                    userList.add(new User(
                            resultSet.getString("numero"),
                            resultSet.getString("username"),
                            resultSet.getString("email"),
                            // Ajout de l'état de vérification
                            btnBLock// Ajout de l'état de blocage

                    ));
                }
            }
            tableViewUsers.setItems(userList);
        } catch (SQLException ex) {
            Logger.getLogger(AffichageUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadData() throws SQLException {
        userList.clear();

        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM `user` WHERE id != 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                boolean isBlocked = !resultSet.getBoolean("etat");
                userList.add(new User(
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("num_tel"),
                        isBlocked // Passer la valeur boolean de l'état
                ));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageUsersController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AffichageUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableViewUsers.setItems(userList);
    }






}
