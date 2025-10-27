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
		manager.setup();

	
	
		boolean continuar= true;
		int opcao;
		while (continuar) {
			System.out.println("1- Criar conta como gestor");
			System.out.println("2- Criar conta como estudante");
			System.out.println("3- Fazer login");
			System.out.println("4-Criar programa");
			System.out.println("5-Sair");
			
			opcao= input.nextInt();
			input.nextLine();
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
				break;
				
			case 2: 
				System.out.println("Insira o nome");
				String nomeS= input.nextLine();
				System.out.println("Insira o email");
				String emailS= input.nextLine();
				System.out.println("Insira a password");
				String passwordS= input.nextLine();
				System.out.println("Insira o numero");
				int numeroS= input.nextInt();
				Student student =new Student(nomeS,emailS,passwordS,numeroS);
				manager.adicionarStudent(student);
				break;
				
			case 3:
				System.out.println("Insira o nome do programa: ");
				String nomeP = input.nextLine();
				
				System.out.println("Insira uma descrição: ");
				String description = input.nextLine();
				
				System.out.println("Insira a localização do programa: ");
				String location = input.nextLine();
				
				System.out.println("Insira o contacto responsável: ");
				int contact = input.nextInt();
				input.nextLine();
				
				System.out.println("Insira a que tipo o programa pertence: ");
				String typeN= input.nextLine();
				
				System.out.println("Insira as vagas que o programa tem: ");
				int vagas = input.nextInt();
				
				//chamar o método
				manager.criarPrograma(nomeP, description, location, contact, typeN, vagas);
				break;
				
				
			case 5:
				continuar=false;
				break;
				
			default: 
				System.out.println("Opção não existe");
			}
			
		
			manager.setup();
			manager.create();
			manager.exit();
		}

	}

	
}
	
