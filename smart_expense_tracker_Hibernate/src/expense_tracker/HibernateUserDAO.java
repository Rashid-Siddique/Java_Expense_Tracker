package expense_tracker;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUserDAO {
	
	public void getUsers() {

	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	    try (Session session = sessionFactory.openSession()) {

	        List<User> users = session
	                .createQuery("from User", User.class)
	                .getResultList();

	        for (User user : users) {

	            System.out.println(
	                user.getUserId() + " | " +
	                user.getName() + " | " +
	                user.getEmail() + " | " +
	                user.getPhoneNumber()
	            );
	        }
	    }
	}

}
