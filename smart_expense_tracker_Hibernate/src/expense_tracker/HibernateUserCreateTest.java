package expense_tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUserCreateTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            User user = new User();

            user.setName("Sara");
            user.setEmail("sara@example.com");
            user.setPhoneNumber("9876543212");

            session.persist(user);

            transaction.commit();

            System.out.println(
                "User created successfully! ID = "
                + user.getUserId()
            );

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