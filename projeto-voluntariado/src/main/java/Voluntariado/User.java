/**
 * 
 */
package Voluntariado;

/**
 * 
 */
public class User {
	private String nome;
	private String email;
	private String password;
	/**
	 * @param nome
	 * @param email
	 * @param password
	 */
	public User(String nome, String email, String password) {
		super();
		this.nome = nome;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	
	
	
}
