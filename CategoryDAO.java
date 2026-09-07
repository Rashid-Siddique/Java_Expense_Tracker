package expense_tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO {

    public void getCategories() {

        String sql = "SELECT * FROM categories";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                String categoryType = resultSet.getString("category_type");

                System.out.println(
                    categoryId + " | " + categoryName + " | " + categoryType
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}