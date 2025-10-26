/**
 * 
 */
package Voluntariado;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Utilizador registado com sucesso: " + user);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
	}
	public void saveType(Type type) {
		Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(type);
            tx.commit();
            System.out.println("Tipo de Programa registado: " + type);
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
	
	public void adicionarType(Type type) {
		saveType(type);
	}
	
	public void printType() {
		 try (Session session = sessionFactory.openSession()) {
		        session.beginTransaction();

		        System.out.println("Lista de Tipos:");
		        List<Type> tipos = session.createQuery("from Type", Type.class).list();
		        for (Type t : tipos) {
		            System.out.println(t);
		        }

		        session.getTransaction().commit();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	public void pesquisarTipo(String tipo) {
		try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();

	        System.out.println("\n=== Find Type by name ===");
	        Query<Type> query = session.createQuery("from Type t where t.type = :name", Type.class);
	        query.setParameter("name", tipo);
	        List<Type> result = query.list();
	        for (Type t : result) {
	            System.out.println(t);
	        }

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
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

