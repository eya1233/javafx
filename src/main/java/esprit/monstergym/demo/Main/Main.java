package esprit.monstergym.demo.Main;

import esprit.monstergym.demo.Entities.User;
import esprit.monstergym.demo.Service.UserService;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Get current date
        java.util.Date currentDate = new java.util.Date();

        // Convert java.util.Date to java.sql.Date
        Date sqlDate = new Date(currentDate.getTime());
        // Test creating a new user
        UserService userService = new UserService();
        User newUser = new User(
                1, // Example ID, replace with actual ID if necessary
                "testuser",
                "testuser@example.com",
                "{\"role\":\"user\"}", // Example roles JSON string, replace with actual JSON string if necessary
                "abc123",
                "password123",
                true,
                sqlDate, // Example date, replace with actual date if necessary
                "123456789",
                123456789,
                1,
                "image_url",
                "borchure_filename"
        );
        userService.create(newUser);
        displayAllUsers(userService);
        // Test updating an existing user
        newUser.setUsername("updatedusername");
        userService.update(newUser);
        System.out.println("After updating:");
        displayAllUsers(userService);

        // Test deleting an existing user
        userService.delete(newUser);
        System.out.println("After deleting:");
        displayAllUsers(userService);

        // Creation of two new users
        User newUser1 = new User(
                2, // Example ID, replace with actual ID if necessary
                "newuser1",
                "newuser1@example.com",
                "{\"role\":\"user\"}", // Example roles JSON string, replace with actual JSON string if necessary
                "abc123",
                "password123",
                true,
                sqlDate, // Example date, replace with actual date if necessary
                "987654321",
                987654321,
                1,
                "new_image_url_1",
                "new_borchure_filename_1"
        );

        User newUser2 = new User(
                3, // Example ID, replace with actual ID if necessary
                "newuser2",
                "newuser2@example.com",
                "{\"role\":\"user\"}", // Example roles JSON string, replace with actual JSON string if necessary
                "abc123",
                "password123",
                true,
                sqlDate, // Example date, replace with actual date if necessary
                "654321987",
                654321987,
                1,
                "new_image_url_2",
                "new_borchure_filename_2"
        );

        // Create and display two new users
        userService.create(newUser1);
        userService.create(newUser2);
        System.out.println("After creating two new users:");
        displayAllUsers(userService);
    }

    private static void displayAllUsers(UserService userService) {
        List<User> userList = userService.getAll();
        System.out.println("All users:");
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
