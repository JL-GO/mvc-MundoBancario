package mvc.view;

import java.util.Scanner;
import mvc.controller.CuentaController;

public class CuentaView {

	private static Scanner tecladoString = new Scanner(System.in);
	private static Scanner tecladoInt = new Scanner(System.in);
	private static Scanner tecladoDouble = new Scanner(System.in);
	private static CuentaController controller = new CuentaController();
	
	public static void printMenuPrincipal() {

		System.out.println("Bienvenido a mi app de gestion de cuentas");
		System.out.println("Que quieres hacer?:");
		System.out.println("1-Alta");
		System.out.println("2-Consultar");
		System.out.println("3-Borrar");
		System.out.println("4-Modificar Saldo");
		System.out.println("5-Listar cuentas");
		System.out.println("6-consultar saldo total de un cliente");
		System.out.println("0-Volver");
		
		int selecion = tecladoInt.nextInt();

		if(selecion !=0){
			controller.seleccionarOpcionMenu(selecion);
		}
	}

	@SuppressWarnings("resource")
	public static void printMenuAlta() {

		System.out.println("Introduce el id del banco");
		int bancoid = tecladoInt.nextInt();

		System.out.println("Introduce el DNI del cliente:");
		String dni = tecladoString.nextLine();
		
		System.out.println("Introduce el saldo de la cuenta:");
		double saldo = tecladoDouble.nextDouble();
		controller.altaCuenta(bancoid, dni, saldo);
		
	}

	public static void printMenuConsulta() {

		System.out.println("Introduce el id de la cuenta");
		int id = tecladoInt.nextInt();
		controller.consultarCuenta(id);

	}

	public static void printMenuBorrado() {

		System.out.println("Introduce el id de la cuenta:");
		int id = tecladoInt.nextInt();
		controller.borrarCuenta(id);
	}
	
	public static void printMenuModificar() {

		System.out.println("Introduce el id de la cuenta");
		int id = tecladoInt.nextInt();
		
		System.out.println("Introduce la el saldo:");
		double saldo = tecladoDouble.nextDouble();
		
		controller.modificarSaldoCuenta(id,saldo);
	}
	
	public static void printMenuListarCuentas() {

		System.out.println("Las cuentas registradas son:");
		controller.listarCuentas();
	}
	
	public static void printMenuSaldoTotal() {
		System.out.println("Introduce el DNI del cliente:");
		String dni = tecladoString.nextLine();
		controller.consultarTotal(dni);
	}
}
