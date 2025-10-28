/**
 * 
 */
package Voluntariado;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


/**
 * 
 */


@Table (name = "Tipo")
@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "tipo_id")
	private long id;
	@Column(nullable = false)
	private String type;
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Program> programas = new ArrayList<>();

	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param programas the programas to set
	 */
	public void setProgramas(List<Program> programas) {
		this.programas = programas;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the programas
	 */
	public List<Program> getProgramas() {
		return programas;
	}

	public void addProgram(Program p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "" + type + "";
	}
	
	
	
}
