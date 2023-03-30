package mvc.view;

import java.util.Scanner;

import mvc.controller.ClienteController;

//la vista no tiene que sar de lógica de negocio, solo se comunicará con el controlador que conectará las peticiones
//con el modelo

public class ClienteView {

	private static Scanner tecladoString = new Scanner(System.in);
	private static Scanner tecladoInt = new Scanner(System.in);
	private static ClienteController controller = new ClienteController();
	
	public static void printMenuPrincipal() {

		System.out.println("Bienvenido a mi app de gestion de clientes");
		System.out.println("Que quieres hacer?:");
		System.out.println("1-Alta");
		System.out.println("2-Consultar");
		System.out.println("3-Borrar");
		System.out.println("4-Modificar Direccion");
		System.out.println("0-Volver");
		
		int selecion = tecladoInt.nextInt();
	
		if(selecion !=0){
			controller.seleccionarOpcionMenu(selecion);
		}
	}

	@SuppressWarnings("resource")
	public static void printMenuAlta() {

		System.out.println("Introduce DNI");
		String dni = tecladoString.nextLine();

		System.out.println("Introduce el nombre:");
		String nombre = tecladoString.nextLine();
		
		System.out.println("Introduce la direccion:");
		String direccion = tecladoString.nextLine();
		
		controller.altaCliente(dni, nombre, direccion);
	}

	public static void printMenuConsulta() {

		System.out.println("Introduce el DNI del cliente:");
		String dni = tecladoString.nextLine();
		
		controller.consultarCliente(dni);

	}

	public static void printMenuBorrado() {

		System.out.println("Introduce el DNI del cliente:");
		String dni = tecladoString.nextLine();
		
		controller.borrarCliente(dni);
	}
	
	public static void printMenuModificar() {

		System.out.println("Introduce el DNI del cliente:");
		String dni = tecladoString.nextLine();
		
		System.out.println("Introduce la nueva direccion del cliente:");
		String direccion = tecladoString.nextLine();
		
		controller.modificarDireccionCliente(dni,direccion);
	}
}
