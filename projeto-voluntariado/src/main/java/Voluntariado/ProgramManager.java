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
import org.hibernate.query.Query;
import java.util.List;

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
	
	public List<Program> searchProgram(String type, String Partner) {
	 try (Session session = sessionFactory.openSession()) {
		 String hql = "FROM Program p WHERE 1=1";
		 if (type != null && !type.isEmpty()) {
			    hql += " AND p.type = :type";
			    }
		 if (partner != null) {
	            hql += " AND p.partner = :partner";
	            }
		 
		 Query<Program> query = session.createQuery(hql, Program.class);
		 
		 if (type != null && !type.isEmpty()) {
	            query.setParameter("type", type);
	            }
	     if (partner != null) {
	            query.setParameter("partner", partner);
	            }
	     return query.list();

	   }
}
	 
	
	public void printPrograms() {
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();

	        System.out.println("\n=== Lista de Todos os Programas ===");
	        List<Program> programs = session.createQuery("from Program", Program.class).list();

	        for (Program p : programs) {
	            System.out.println(p);
	        }

	        String nameParam = "Limpeza de Praia"; 
	        System.out.println("\n=== Programas com nome: " + nameParam + " ===");
	        Query<Program> query = session.createQuery(
	            "from Program p where p.nomeP = :name", Program.class);
	        query.setParameter("name", nameParam);
	        List<Program> result = query.list();

	        for (Program r : result) {
	            System.out.println(r);
	        }

	}
		

    
