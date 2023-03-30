package mvc.view;

import java.util.Scanner;

import mvc.controller.BancoController;

public class BancoView {
	
	private static Scanner tecladoString = new Scanner(System.in);
	private static Scanner tecladoInt = new Scanner(System.in);
	private static BancoController controller = new BancoController();
	
	public static void printMenuPrincipal() {

		System.out.println("Bienvenido a mi app de gestion de bancos");
		System.out.println("Que quieres hacer?:");
		System.out.println("1-Alta");
		System.out.println("2-Consultar");
		System.out.println("3-Borrar");
		System.out.println("4-Modificar Ciudad");
		System.out.println("5-Listar bancos");
		System.out.println("0-Volver");
		
		int selecion = tecladoInt.nextInt();

		if(selecion !=0){
			controller.seleccionarOpcionMenu(selecion);
		}
	}

	@SuppressWarnings("resource")
	public static void printMenuAlta() {

		System.out.println("Introduce nombre del banco");
		String nombre = tecladoString.nextLine();

		System.out.println("Introduce la ciudad:");
		String ciudad = tecladoString.nextLine();
		
		controller.altaBanco(nombre, ciudad);
	}

	public static void printMenuConsulta() {

		System.out.println("Introduce el id del Banco");
		int id = tecladoInt.nextInt();
		controller.consultarBanco(id);

	}

	public static void printMenuBorrado() {

		System.out.println("Introduce el id del Banco:");
		int id = tecladoInt.nextInt();
		controller.borrarBanco(id);
	}
	
	public static void printMenuModificar() {

		System.out.println("Introduce el id del Banco:");
		int id = tecladoInt.nextInt();
		
		System.out.println("Introduce la nueva Ciudad del Banco:");
		String nuevaCiudad = tecladoString.nextLine();
		
		controller.modificarCiudadBanco(id,nuevaCiudad);
	}
	
	public static void printMenuListarBancos() {

		System.out.println("Los bancos registrados son:");
		controller.listarBancos();
	}
	
}