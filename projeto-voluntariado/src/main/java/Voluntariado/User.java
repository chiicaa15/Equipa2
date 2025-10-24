/**
 * 
 */
package Voluntariado;
import jakarta.persistence.*; 
/**
 * 
 */
@Entity
@Table (name="users")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn (name = "user_type", discriminatorType = 
DiscriminatorType.STRING) 
public class User {
	@Id
	@Column (name="user_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private String name;
	@Column (nullable = false)
	private String email;
	@Column (nullable = false)
	private String password;
	/**
	 * @param nome
	 * @param email
	 * @param password
	 */
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getNome() {
		return name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
