package expense_tracker;

public class HibernateUserTest {

    public static void main(String[] args) {

        HibernateUserDAO userDAO = new HibernateUserDAO();

        userDAO.getUsers();
    }
}