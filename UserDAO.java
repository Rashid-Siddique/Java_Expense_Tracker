package expense_tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void getUsers() {

        String sql = "SELECT * FROM users";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int userId = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");

                System.out.println(
                    userId + " | " + name + " | " + email + " | " + phone
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addUser(String name, String email, String phoneNumber) {

        String sql = "INSERT INTO users (name, email, phone_number) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);

            int rows = statement.executeUpdate();

            System.out.println(rows + " user added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}