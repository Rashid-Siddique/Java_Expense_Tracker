package expense_tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TransactionDAO {

    public void getTransactions() {

        String sql = "SELECT * FROM transactions";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int transactionId = resultSet.getInt("transaction_id");
                int accountId = resultSet.getInt("account_id");
                int categoryId = resultSet.getInt("category_id");
                double amount = resultSet.getDouble("amount");
                String merchantName = resultSet.getString("merchant_name");
                String paymentMode = resultSet.getString("payment_mode");
                String transactionDate = resultSet.getString("transaction_date");
                String transactionType = resultSet.getString("transaction_type");

                System.out.println(
                    transactionId + " | " +
                    accountId + " | " +
                    categoryId + " | " +
                    amount + " | " +
                    merchantName + " | " +
                    paymentMode + " | " +
                    transactionDate + " | " +
                    transactionType
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addTransaction(
            int accountId,
            int categoryId,
            double amount,
            String merchantName,
            String paymentMode,
            String transactionType) {

        String sql = "INSERT INTO transactions " +
                     "(account_id, category_id, amount, merchant_name, " +
                     "payment_mode, transaction_date, transaction_type) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        LocalDateTime dateTime = LocalDateTime.now();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, accountId);
            statement.setInt(2, categoryId);
            statement.setDouble(3, amount);
            statement.setString(4, merchantName);
            statement.setString(5, paymentMode);
            statement.setTimestamp(6, Timestamp.valueOf(dateTime));
            statement.setString(7, transactionType);

            int rows = statement.executeUpdate();

            System.out.println(rows + " transaction added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateTransaction(double amount, int transactionId) {

        String sql = "UPDATE transactions SET amount = ? WHERE transaction_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, amount);
            statement.setInt(2, transactionId);

            int rows = statement.executeUpdate();

            System.out.println(rows + " transaction updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTransaction(int transactionId) {

        String sql = "DELETE FROM transactions WHERE transaction_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, transactionId);

            int rows = statement.executeUpdate();

            System.out.println(rows + " transaction deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}