package expense_tracker;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            Map<String, Object> settings = new HashMap<>();

            settings.put(
                "hibernate.connection.driver_class",
                "com.mysql.cj.jdbc.Driver"
            );

            settings.put(
                "hibernate.connection.url",
                "jdbc:mysql://localhost:3306/expense_tracker"
            );

            settings.put(
                "hibernate.connection.username",
                "root"
            );

            settings.put(
                "hibernate.connection.password",
                "Rashid9890@"
            );

            settings.put(
                "hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect"
            );

            settings.put(
                "hibernate.show_sql",
                true
            );

            settings.put(
                "hibernate.format_sql",
                true
            );

            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(settings)
                            .build();

            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(User.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }

        return sessionFactory;
    }
}