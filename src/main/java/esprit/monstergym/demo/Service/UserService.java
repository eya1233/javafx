package esprit.monstergym.demo.Service;

import esprit.monstergym.demo.Entities.User;
import esprit.monstergym.demo.Interfaces.IService;
import esprit.monstergym.demo.Utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService implements IService<User> {

    @Override
    public void create(User entity) {
        // Implement the logic to insert a new user into the database
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user ( username, email, roles, reset_token, password, is_verified, date_naissance, numero, cin, etat, image_url, borchure_filename) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getRoles());
            preparedStatement.setString(4, entity.getResetToken());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.setBoolean(6, entity.isVerified());
            preparedStatement.setTimestamp(7, new Timestamp(entity.getDateNaissance().getTime()));
            preparedStatement.setString(8, entity.getNumero());
            preparedStatement.setInt(9, entity.getCin());
            preparedStatement.setInt(10, entity.getEtat());
            preparedStatement.setString(11, entity.getImageUrl());
            preparedStatement.setString(12, entity.getBrochureFilename());

            preparedStatement.executeUpdate();
            System.out.println("User created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public void update(User entity) {
        // Implement the logic to insert a new user into the database
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  user SET  username = ?, email = ?, roles = ?, reset_token = ?, password = ?, is_verified = ?, date_naissance = ?, numero = ?, cin = ?, etat = ?, image_url = ?, borchure_filename = ? WHERE id = ?")) {

            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getRoles());
            preparedStatement.setString(4, entity.getResetToken());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.setBoolean(6, entity.isVerified());
            preparedStatement.setTimestamp(7, new Timestamp(entity.getDateNaissance().getTime()));
            preparedStatement.setString(8, entity.getNumero());
            preparedStatement.setInt(9, entity.getCin());
            preparedStatement.setInt(10, entity.getEtat());
            preparedStatement.setString(11, entity.getImageUrl());
            preparedStatement.setString(12, entity.getBrochureFilename());
            preparedStatement.setInt(13, entity.getId());

            preparedStatement.executeUpdate();
            System.out.println("User created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public void delete(User entity) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id =  ?")) {

            preparedStatement.setInt(1, entity.getId());


            preparedStatement.executeUpdate();
            System.out.println("User deleted successfully");
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        // Implement the logic to retrieve all users from the database and populate the userList
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
            while (resultSet.next()) {
                // Retrieve user attributes from the resultSet and create a User object
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String roles = resultSet.getString("roles");
                String resetToken = resultSet.getString("reset_token");
                String password = resultSet.getString("password");
                boolean isVerified = resultSet.getBoolean("is_verified");
                Date dateNaissance = resultSet.getDate("date_naissance");
                String numero = resultSet.getString("numero");
                Integer cin = resultSet.getInt("cin");
                Integer etat = resultSet.getInt("etat");
                String imageUrl = resultSet.getString("image_url");
                String borchureFilename = resultSet.getString("borchure_filename");

                User user = new User(id, username, email, roles, resetToken, password, isVerified,
                        dateNaissance, numero, cin, etat, imageUrl, borchureFilename);
                userList.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error getting all users: " + e.getMessage());
        }
        return userList;
    }

}
