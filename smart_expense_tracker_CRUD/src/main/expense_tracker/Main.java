package expense_tracker;

public class Main {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        userDAO.getUsers();

        System.out.println("\n--- Categories ---");

        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.getCategories();
        
        System.out.println("\n--- Accounts ---");

        AccountDAO accountDAO = new AccountDAO();
        accountDAO.getAccounts();
        
        System.out.println("\n--- Transactions ---");

        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.getTransactions();
        
        System.out.println("\n--- Adding Test Transaction ---");
//
//        transactionDAO.addTransaction(
//            1,
//            10,
//            100.00,
//            "Test Merchant",
//            "CASH",
//            "EXPENSE"
//        );
        
        System.out.println("\n--- Updating Transaction ---");

        transactionDAO.updateTransaction(650.00, 2);
        
        System.out.println("\n--- Deleting Test Transaction ---");

        transactionDAO.deleteTransaction(5);
    }
}