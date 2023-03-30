package mvc.controller;

import java.util.List;

import mvc.model.entity.Banco;
import mvc.model.service.BancoService;
import mvc.view.BancoView;

public class BancoController {
	
	private BancoService service = new BancoService();

	public void seleccionarOpcionMenu(int seleccion) {
		switch (seleccion) {
		case 1:
			BancoView.printMenuAlta();
			break;
		case 2:
			BancoView.printMenuConsulta();
			break;
		case 3:
			BancoView.printMenuBorrado();
			break;
		case 4:
			BancoView.printMenuModificar();
			break;
		case 5:
			BancoView.printMenuListarBancos();
			break;
		default:
			System.out.println("Opcian no valida");
			BancoView.printMenuPrincipal();
		}
	}

	public void altaBanco(String nombre, String ciudad) {

			service.alta(nombre, ciudad);
			BancoView.printMenuPrincipal();
	}

	public void consultarBanco(int id) {

		if(service.consulta(id) == null) {
			System.out.println("Id no encontrado");
			BancoView.printMenuConsulta();
		}else {
			System.out.println(service.consulta(id));
			BancoView.printMenuPrincipal();
		}
	}

	public void borrarBanco(int id) {

		if(service.consulta(id) == null) {
			System.out.println("Id no encontrado");
			BancoView.printMenuBorrado();
		}else {
			System.out.println("Se ha borrado el "+ service.borrar(id)); 
			BancoView.printMenuPrincipal();
		}
	}
	
	public void modificarCiudadBanco(int id, String nuevaCiudad) {

		if(service.consulta(id) == null) {
			System.out.println("Id no encontrado");
			BancoView.printMenuModificar();
		}else {
			System.out.println("Se ha actualizado el "+ service.modificarCiudad(id,nuevaCiudad)); 
			BancoView.printMenuPrincipal();
		}
		
	}

	public void listarBancos() {
		
		List<Banco> bancos = service.listarBancos();
		
		for (Banco banco : bancos) {
			System.out.println(banco);
		}
		BancoView.printMenuPrincipal();
	}
}
