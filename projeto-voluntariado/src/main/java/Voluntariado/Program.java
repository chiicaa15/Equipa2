/**
 * 
 */
package Voluntariado;

/**
 * 
 */
public class Program {
	private String nomeP;
	private String partner;
	private String description;
	private String type;
	private String location;
	private int contact;
	/**
	 * @param nomeP
	 * @param partner
	 * @param description
	 * @param type
	 * @param location
	 * @param contact
	 */
	public Program(String nomeP, String partner, String description, String type, String location, int contact) {
		super();
		this.nomeP = nomeP;
		this.partner = partner;
		this.description = description;
		this.type = type;
		this.location = location;
		this.contact = contact;
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
	 * @return the partner
	 */
	public String getPartner() {
		return partner;
	}
	/**
	 * @param partner the partner to set
	 */
	public void setPartner(String partner) {
		this.partner = partner;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
		return "Program [nomeP=" + nomeP + ", partner=" + partner + ", description=" + description + ", type=" + type
				+ ", location=" + location + ", contact=" + contact + "]";
	}
	


}
