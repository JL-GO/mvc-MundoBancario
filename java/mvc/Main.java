package mvc;

import java.util.Scanner;

import mvc.view.BancoView;
import mvc.view.ClienteView;
import mvc.view.CuentaView;


public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int selecion;
		do {
			System.out.println("Hola mundo Bancario");
			System.out.println("Sobre que entidad quiere operar:");
			System.out.println("1.Clientes");
			System.out.println("2.Bancos");
			System.out.println("3.Cuentas");
			System.out.println("0.Salir");
			
			Scanner tecladoInt = new Scanner(System.in);
			selecion = tecladoInt.nextInt();
			
			switch(selecion) {
				case 0: break;
				case 1: ClienteView.printMenuPrincipal();break;
				case 2: BancoView.printMenuPrincipal();break;
				case 3: CuentaView.printMenuPrincipal();break;
				}
			
			}while(selecion != 0);
	}

}
