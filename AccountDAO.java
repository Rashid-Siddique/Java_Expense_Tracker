package expense_tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
	
	public void getAccounts() {

	    String sql = "SELECT * FROM accounts";

	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {

	            int accountId = resultSet.getInt("account_id");
	            int userId = resultSet.getInt("user_id");
	            String bankName = resultSet.getString("bank_name");
	            String accountType = resultSet.getString("account_type");
	            String lastDigits = resultSet.getString("last_digits");

	            System.out.println(
	                accountId + " | " +
	                userId + " | " +
	                bankName + " | " +
	                accountType + " | " +
	                lastDigits
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
