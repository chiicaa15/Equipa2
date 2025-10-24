/**
 * 
 */
package Voluntariado;
import org.hibernate.Session;
/**
 * 
 */
public class Main {
	public static void main(String[]args) {
		ProgramManager manager = new ProgramManager();
			manager.setup();
			manager.create();
			manager.exit();
	}
}
	
