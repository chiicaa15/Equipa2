/**
 * 
 */
package Voluntariado;
import org.hibernate.Session;
/**
 * 
 */
public class Main {
	public static void main(String[]args) {
		
	
	case 1:
		System.out.println("Insira o nome do programa: ");
		String nomeP = input.nextLine();
		
		System.out.println("Insira uma descrição: ");
		String description = input.nextLine();
		
		System.out.println("Insira a localização do programa: ");
		String location = input.nextLine();
		
		System.out.println("Insira o contacto responsável: ");
		int contact = input.nextLine();
		
		System.out.println("Insira a que tipo o programa pertence: ");
		String type = input.nextLine();
		
		//chamar o método
		Program p = new Program(nomeP, description, location, contact, type);
		manager.criarPrograma(p);
		
	}
	
	
	
}
