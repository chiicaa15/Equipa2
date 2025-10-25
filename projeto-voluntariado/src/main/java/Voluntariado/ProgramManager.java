/**
 * 
 */
package Voluntariado;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
	public ArrayList<User>users= new ArrayList();
	
	public void setup() {
		 sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public void saveUser(User user) {
		Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            System.out.println("User registado com sucesso: " + user);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
	}
	
	public void adicionarUser(User novoUser) {
		users.add(novoUser);
		saveUser(novoUser);
		
	}
	public void adicionarStudent(Student novoStudent) {
		users.add(novoStudent);
		saveUser(novoStudent);
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

