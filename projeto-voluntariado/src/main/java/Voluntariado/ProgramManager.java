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
import org.hibernate.query.Query;
/**
 * 
 */
public class ProgramManager {
	public SessionFactory sessionFactory;
	public ArrayList<User>users= new ArrayList();
	public ArrayList<Program>programs=new ArrayList();
	
	public ProgramManager() {
		
	}
	
	public void create() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	public void setup() {
		 sessionFactory = HibernateUtil.getSessionFactory(); //Inicializar ligação com base de dados
	}
	
	//Método para persistir user
	public void saveUser(User user) {
		Transaction tx = null;
        try (Session session = sessionFactory.openSession()) { //Abrir ligação com a base de dados
            tx = session.beginTransaction(); // Iniciar transação 	
            session.persist(user); // persiste user
            tx.commit(); 
            System.out.println("Utilizador registado com sucesso: " + user);
        } catch (Exception e) {
            if (tx != null) tx.rollback(); // faz um rollback se algo falhar
            e.printStackTrace();
        }
	}
	
	//Método para persistir o tipo de programa
	public void saveType(Type type) {
		Transaction tx = null;
        try (Session session = sessionFactory.openSession()) { // Abrir ligação com base de dados
            tx = session.beginTransaction();
            session.persist(type);
            tx.commit();
            System.out.println("Tipo de Programa registado: " + type);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
	}
	
	//Método para persistir um programa
	public void saveProgram(Program program) {
		Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(program);
            tx.commit();
            System.out.println("Programa registado: " + program);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
	}
	
	//Método para adicionar um novo User
	public void adicionarUser(User novoUser) {
		users.add(novoUser);
		saveUser(novoUser); //Chama o método saveUser para salvar user na base de dados
		
	}
	
	//Método para adicionar um novo estudante
	public void adicionarStudent(Student novoStudent) {
		users.add(novoStudent);
		saveUser(novoStudent);//Chama o método saveUser para salvar o estudante na base de dados
	}
	
	//Método para adicionar um tipo
	public void adicionarType(Type type) {
		saveType(type); // Chama o método saveType para salvar o tipo na base de dados
	}
	
	//Método para adicionar um programa 
	public void adicionarPrograma(Program program) {
		saveProgram(program); // Chama o método saveProgram para salvar o tipo na base de dados
	}
	
	//Método para imprimir Tipos de programa
	public void printType() {
		 try (Session session = sessionFactory.openSession()) {
		        session.beginTransaction();

		        System.out.println("Lista de Tipos de Programa:");
		        List<Type> tipos = session.createQuery("from Type", Type.class).list();// criar um query(questionar base de dados) para selecionar todos os objetos da classe Type
		        for (Type t : tipos) {
		            System.out.println(t);// ciclo for para obter cada objeto
		        }
		        session.getTransaction().commit();
		    } catch (Exception e) { // exceção de erro
		        e.printStackTrace();
		    }
		 }
	
	//Método para pesquisar
	public void pesquisarTipo(String tipo) {
		try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();

	        Query<Type> query = session.createQuery("from Type t where t.type = :name", Type.class);// consulta para buscar objetos da entidade Type
	        query.setParameter("name", tipo);
	        List<Type> result = query.list(); //executa o query e devolve a lista de objetos encontrados na classe Type
	        for (Type t : result) {
	            System.out.println(t);
	        }

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	//Método para imprimir utilizadores
	public void printUsers() {
		try (Session session= sessionFactory.openSession()){
			session.beginTransaction();

	        System.out.println("Lista de Tipos de Utilizadores:");
	        List<User> users = session.createQuery("from User", User.class).list();// criar um query(questionar base de dados) para selecionar todos os objetos da classe User
	        for (User u: users) { //ciclo for para imprimir um user de cada vez
	        	System.out.println(u);
	        }
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	//Método para criar Programa a associar a um tipo
	public void criarPrograma(Program p, String typeName) {
	    Transaction tx = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        tx = session.beginTransaction();

	        // Procurar o Type
	        Query<Type> query = session.createQuery("from Type where type = :type", Type.class);
	        query.setParameter("type", typeName);//Procura se ja existe o type com o nome fornecido (typename)
	        List<Type> tipos = query.getResultList();
	        Type type;
	        if (tipos.isEmpty()) {// Se o tipo nao exitir cria um tipo
	            type = new Type();
	            type.setType(typeName);
	            session.persist(type);
	        } else {
	            type = tipos.get(0);
	        }

	        // Associar o Type ao Programa
	        p.setType(type);
	        type.adicionarPrograma(p);

	        // Persistir o Program
	        session.persist(p);

	        tx.commit();
	        System.out.println("Programa criado com sucesso: " + p.getNomeP());
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	        System.out.println("Erro ao criar programa: " + e.getMessage());
	    }
	}
	
	//Imprimir Programas
	public void imprimirProgramas() {
		
		try (Session session = sessionFactory.openSession()){
			session.beginTransaction();
			
			List <Program>programs = session.createQuery("from Program", Program.class).list();// Cria um query, procura e devolve os programas
			for(Program p: programs) { //ciclo para imprimir um programa de cada vez
				System.out.println(p);
			}
			session.getTransaction().commit();
		}
	}
	
	public void setLocalizacaoPrograma(String nomePrograma, String novaLocalizacao) {
	    Transaction tx = null; // Declarar transação
	    try (Session session = sessionFactory.openSession()) { 
	        tx = session.beginTransaction(); //Inicia transação

	        // Procurar o programa pelo nome	
	        Query<Program> query = session.createQuery("from Program where nomeP = :nome", Program.class);//consulta para buscar objetos da entidade Program
	        query.setParameter("nome", nomePrograma); // define o valor do parametro (nome) na query e substitui pelo conteúdo da variavel nomePrograma
	        List<Program> programas = query.getResultList();// criar um query(questionar base de dados) para selecionar todos os objetos da classe Program

	        if (!programas.isEmpty()) {
	            Program p = programas.get(0); // pega o primeiro resultado (caso haja duplicados)
	            p.setLocation(novaLocalizacao); // altera a localização

	            tx.commit();
	            System.out.println("Localização atualizada com sucesso para: " + novaLocalizacao);
	        } else {
	            System.out.println("Programa com o nome '" + nomePrograma + "' não encontrado.");
	            tx.rollback();
	        }

	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	        System.out.println("Erro ao atualizar a localização: " + e.getMessage());
	    }
	}
            
}

