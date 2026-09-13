package expense_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	 public User() {
	    }
	 public int getUserId() {
		    return userId;
		}

		public void setUserId(int userId) {
		    this.userId = userId;
		}

		public String getName() {
		    return name;
		}

		public void setName(String name) {
		    this.name = name;
		}

		public String getEmail() {
		    return email;
		}

		public void setEmail(String email) {
		    this.email = email;
		}

		public String getPhoneNumber() {
		    return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
		    this.phoneNumber = phoneNumber;
		}
}