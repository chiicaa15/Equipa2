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
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * 
 */
public class ProgramManager {
	public SessionFactory sessionFactory;
	public ArrayList<User>users= new ArrayList();
	public ArrayList<Program>programs = new ArrayList();
	
	
	
	public ProgramManager(ArrayList<Program> programs, ArrayList<Student> students, ArrayList<User> users) {
		super();
		
	}
	
	
	public void criarPrograma (String nomeP, String description, String location, int contact, String type, int vagas) {
		
		//verificar se está vazio ou não
		if (nomeP.isEmpty() || description.isEmpty() || location.isEmpty() || type.isEmpty()) {
			System.out.println("Todos os campos têm de ser preenchidos!");
			return;
		}
			
		
		Transaction tx = null; //tx guarda a transação
		try (Session session = HibernateUtil.getSessionFactory().openSession()){ //abre uma nova sessão com b.dados e guarda em session
			tx = session.beginTransaction(); //começa
			
			
			//verificar se o tipo existe, se não cria
			Query<Type> query = session.createQuery("from Type where type = :type", Type.class);
			query.setParameter("type", type);
			Type type1 = query.uniqueResult();
			
			if (type1 == null) {
				type1 = new Type(); //typeType pra usar o valor
				session.persist(type1);
			}
			
			
			//criação do programa e adicionar o programa a um dado type
			Program p = new Program (nomeP, description, location, contact, type1, vagas);
			session.persist(p);
			programs.add(p);
			
			tx.commit();
			
			System.out.println("O programa foi criado com sucesso!");
		}
		
		catch (Exception e) {
			
			
			//se algo deu errado, nada irá ser salvo
			if (tx != null) tx.rollback(); 
			e.printStackTrace();
			System.out.println("Programa não criado por: " + e.getMessage());} //mostra os motivos de não ter sido criado
		}
		

	
	public List listarTProgramas() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		try (Session session = factory.openSession()){
			session.beginTransaction();
			
			List programs = session.createQuery("from Program", Program.class).list();
			
			session.getTransaction().commit();
			
			return programs;
		}
	}
	
	
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


	public void criarPrograma(Program p) {
		// TODO Auto-generated method stub
		
	}


}

