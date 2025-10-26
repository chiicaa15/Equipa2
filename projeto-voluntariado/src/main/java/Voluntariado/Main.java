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
		while (continuar=true) {
			System.out.println("1- Criar conta como gestor");
			System.out.println("2- Criar conta como estudante");
			System.out.println("3-Criar um tipo de programa");
			System.out.println("4-Criar programa");
			System.out.println("5- ");
			System.out.println("7-Sair");
			
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
				System.out.println("Insira o nome: ");
				String nomeS= input.nextLine();
				System.out.println("Insira o email: ");
				String emailS= input.nextLine();
				System.out.println("Insira a password: ");
				String passwordS= input.nextLine();
				System.out.println("Insira o numero: ");
				int numeroS= input.nextInt();
				Student student =new Student(nomeS,emailS,passwordS,numeroS);
				manager.adicionarStudent(student);
				break;
				
			case 3:
				System.out.println("Insira um tipo de progranma: ");
				String nomeTipo=input.nextLine();
				Type type= new Type(nomeTipo);
				manager.adicionarType(type);
				break;
				
			case 4:
				manager.printType();
				System.out.println("Escolha um tipo");
				String tipo=input.nextLine();
				
				System.out.println("Insira um nome: ");
				String nomeP=input.nextLine();
				System.out.println("Insira uma descrição: ");
				String descricao= input.nextLine();
				System.out.println("Insira uma localização: ");
				String localizacao=input.nextLine();
				System.out.println("Insira o contacto: ");
				int contacto= input.nextInt();
				System.out.println("Insira número de vagas: ");
				int vagas=input.nextInt();
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
	
