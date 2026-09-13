package expense_tracker;

import org.hibernate.SessionFactory;

public class HibernateTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();

        System.out.println(
                "Hibernate SessionFactory created successfully!"
        );

        sessionFactory.close();
    }
}