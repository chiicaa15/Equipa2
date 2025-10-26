/**
 * 
 */
package Voluntariado;
import java.util.Scanner;

import org.hibernate.Session;
/**
 * 
 */
public class Main {
	public static void main(String[]args) {
		ProgramManager manager = new ProgramManager();
		Scanner input = new  Scanner(System.in);
		
		boolean continuar= true;
		int opcao;
		while (continuar=true) {
			System.out.println("1- Criar conta como gestor");
			System.out.println("2- Criar conta como estudante");
			System.out.println("3- Fazer login");
			System.out.println("Criar programa");
			
			opcao= input.nextInt();
			switch(opcao) {
			case 1 :
				System.out.println("Insira o nome");
				String nome= input.nextLine();
				System.out.println("Insira o email");
				String email= input.nextLine();
				System.out.println("Insira a password");
				String password= input.nextLine();
				User user= new User(nome,email,password);
				manager.adicionarUser(user);
				
			case 2: 
				System.out.println("Insira o numero");
				int numero= input.nextInt();
				manager.adicionarStudent(numero);
			
			}
			
		
			manager.setup();
			manager.create();
			manager.exit();
		}
	}
}
	
