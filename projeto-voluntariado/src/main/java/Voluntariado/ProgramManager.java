/**
 * 
 */
package Voluntariado;

import java.util.ArrayList;
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.boot.MetadataSources; 
import org.hibernate.boot.registry.StandardServiceRegistry; 
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import util.HibernateUtil;
import jakarta.transaction.Transaction;
/**
 * 
 */
public class ProgramManager {
	public SessionFactory sessionFactory;
	public ArrayList<User>users= new ArrayList();
	
	public void adicionarUser(User novoUser) {
		users.add(novoUser);
		saveUser(novoUser);
		
	}
	public void adicionarStudent(Student novoStudent) {
		users.add(novoStudent);
		saveUser(novoStudent);
	}
	
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
	public void saveUser() {
		Transaction tx = null; 
		try (Session session =HibernateUtil.getSessionFactory().openSession()) { 
		            tx = session.beginTransaction(); 
		            session.persist(user); 
		            tx.commit(); 
		            System.out.println("User registado com secesso: " + user); 
		        } catch (Exception e) { 
		            if (tx != null) tx.rollback(); 
		            e.printStackTrace(); 
		        } 
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
}

