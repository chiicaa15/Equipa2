/**
 * 
 */
package Voluntariado;

import java.util.ArrayList;

import org.hibernate.Session;

import jakarta.transaction.Transaction;


/**
 * 
 */
public class ProgramManager {
	
	private ArrayList <Program> programs;
	private ArrayList <Type> tipos;
	
	
	public ProgramManager(ArrayList<Program> programs, ArrayList<Student> students, ArrayList<User> users) {
		super();
		
	}
	
	/*
	 * public boolean login (String nome, String email, String password ) {
	 * 
	 * 
	 * return false;
	 * 
	 * }
	 */
	
	
	
	public void criarPrograma (String nomeP, String description, String location, int contact, String type) {
		
		//verificar se está vazio ou não
		if (nomeP.isEmpty() || description.isEmpty() || location.isEmpty() || contact.isEmpty || type.isEmpty()) {
			System.out.println("Todos os campos têm de ser preenchidos!");
			return;
		}
			
		
		Transaction tx = null; //tx guarda a transação
		try (Session session = HibernateUtil.getSessionFactory().openSessions()){ //abre uma nova sessão com b.dados e guarda em session
			tx = session.beginTransaction(); //começa
			
			
			//verificar se o tipo existe, se não cria
			Query<Type> query = session.createQuery("from Type where type = :type", Type.class);
			query.setParameter("type", typeType);
			Type type = query.uniqueResult();
			
			if (type == null) {
				type = new Type(typeType); //typeType pra usar o valor
				session.persist(type);
			}
			
			
			//criação do programa e adicionar o programa a um dado type
			Program p = new Program (nomeP, description, location, contact, type);
			session.persist(p);
			type.getProgramas().add(p);
			
			tx.commit();
			
			System.out.println("O programa foi criado com sucesso!");
		}
		
		catch (Exception e) {
			
			
			//se algo deu errado, nada irá ser salvo
			if (tx = null) tx.rollback(); 
			e.printStackTrace();
			System.out.println("Programa não criado por: " + e.getMessage()); //mostra os motivos de não ter sido criado
		}
		
		
		
		
		
	}
	
}
