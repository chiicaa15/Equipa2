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
	
	
	public void criarPrograma (String nomeP, String description, String location, int contact) {
		
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSessions()){
			tx = session.beginTransaction();
			
			Program p = new Program (nomeP, description, location, contact);
			session.persist(p);
			
			tx.commit();
			
			System.out.println("O programa foi criado com sucesso!");
		}
		
		catch (Exception e) {
			if (tx = null) tx.rollback();
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
