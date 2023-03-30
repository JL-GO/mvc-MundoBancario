package mvc.controller;

import mvc.model.service.ClienteService;
import mvc.view.ClienteView;

//su funcion es validar los datos de entrada/salida y controlar la navegación por la interfaz
public class ClienteController {

	private ClienteService service = new ClienteService();

	public void seleccionarOpcionMenu(int seleccion) {
		switch (seleccion) {
		case 1:
			ClienteView.printMenuAlta();
			break;
		case 2:
			ClienteView.printMenuConsulta();
			break;
		case 3:
			ClienteView.printMenuBorrado();
			break;
		case 4:
			ClienteView.printMenuModificar();
			break;
		default:
			System.out.println("Opcian no valida");
			ClienteView.printMenuPrincipal();
		}
	}

	public void altaCliente(String dni, String nombre, String direccion) {

		if (dni.length() != 9) {
			System.out.println("Formato de DNI incorrecto");
			ClienteView.printMenuAlta();
		} else {
			service.alta(dni, nombre, direccion);
			ClienteView.printMenuPrincipal();
		}
	}

	public void consultarCliente(String dni) {

		if (dni.length() != 9) {
			System.out.println("Formato de DNI incorrecto");
			ClienteView.printMenuConsulta();
		} else {
			System.out.println(service.consulta(dni));
			ClienteView.printMenuPrincipal();
		}
	}

	public void borrarCliente(String dni) {

		if (dni.length() != 9) {
			System.out.println("Formato de DNI incorrecto");
			ClienteView.printMenuBorrado();
		} else {
			System.out.println("Se ha borrado el "+ service.borrar(dni)); 
			ClienteView.printMenuPrincipal();
		}
	}
	
	public void modificarDireccionCliente(String dni, String nuevaDireccion) {

		if (dni.length() != 9) {
			System.out.println("Formato de DNI incorrecto");
			ClienteView.printMenuModificar();
		} else {
			System.out.println("Se ha actualizado el "+ service.modificarDireccion(dni,nuevaDireccion)); 
			ClienteView.printMenuPrincipal();
		}
	}

}
