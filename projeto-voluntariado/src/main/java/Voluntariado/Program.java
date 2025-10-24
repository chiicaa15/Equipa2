/**
 * 
 */
package Voluntariado;

import jakarta.persistence.*; 
/**
 * 
 */
@Entity
@Table(name="Programs")
public class Program {
	
	@Id
	@Column(name= "program_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nomeP;
	private String description;
	private String location;
	private int contact;
	private int vagas;
	/**
	 * @param nomeP
	 * @param description
	 * @param location
	 * @param contact
	 */
	public Program(String nomeP, String description, String location, int contact, int vagas) {
		this.nomeP = nomeP;
		this.description = description;
		this.location = location;
		this.contact = contact;
		this.vagas= vagas;
	}
	
	/**
	 * @return the vagas
	 */
	public int getVagas() {
		return vagas;
	}

	/**
	 * @param vagas the vagas to set
	 */
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	/**
	 * @return the nomeP
	 */
	public String getNomeP() {
		return nomeP;
	}
	/**
	 * @param nomeP the nomeP to set
	 */
	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the contact
	 */
	public int getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Program [nomeP=" + nomeP + ", description=" + description + ", location=" + location + ", vagas="+ vagas +", contact=" + contact + "]";
	}
	


}
