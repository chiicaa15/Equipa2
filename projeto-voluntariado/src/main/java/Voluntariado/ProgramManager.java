/**
 * 
 */
package Voluntariado;
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.boot.MetadataSources; 
import org.hibernate.boot.registry.StandardServiceRegistry; 
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * 
 */
public class ProgramManager {
	public SessionFactory sessionFactory;
	
	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure()
			.build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void exit() {
		
	}
	
	public void create() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		
	}
	public void read() {
		
	}
	public void update() {
		
	}
	public void delete() {
		
	}
	
	//public void applyPrograms() {
		//if (program != closed) {
			
		//}
		
		//System.out.print("U sucessfuly applied to the program");
	//}
	
	public void searchProgram() {
		
	}
	
	public void printProgram() {
		
	}
}

    
