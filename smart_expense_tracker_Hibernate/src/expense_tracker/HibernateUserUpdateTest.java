package expense_tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUserUpdateTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            User user = session.get(User.class, 4);

            if (user != null) {

                user.setPhoneNumber("9876543213");

                transaction.commit();

                System.out.println("User updated successfully!");

            } else {

                System.out.println("User not found.");
                transaction.rollback();
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            sessionFactory.close();
        }
    }
}