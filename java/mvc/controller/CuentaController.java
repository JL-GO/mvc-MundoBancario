package mvc.controller;

import java.util.List;

import mvc.model.entity.Cuenta;
import mvc.model.service.BancoService;
import mvc.model.service.ClienteService;
import mvc.model.service.CuentaService;
import mvc.view.CuentaView;



public class CuentaController {
	
	private BancoService bancoService = new BancoService();
	private ClienteService clienteService = new ClienteService();
	private CuentaService service = new CuentaService();

	public void seleccionarOpcionMenu(int seleccion) {
		switch (seleccion) {
		case 1:
			CuentaView.printMenuAlta();
			break;
		case 2:
			CuentaView.printMenuConsulta();
			break;
		case 3:
			CuentaView.printMenuBorrado();
			break;
		case 4:
			CuentaView.printMenuModificar();
			break;
		case 5:
			CuentaView.printMenuListarCuentas();
			break;
		case 6:
			CuentaView.printMenuSaldoTotal();
			break;
		default:
			System.out.println("Opcian no valida");
			CuentaView.printMenuPrincipal();
		}
	}

	public void altaCuenta(int bancoid, String dni, double saldo) {

		if(bancoService.consulta(bancoid) == null) {
			System.out.println("El id del banco no existe");
		}else if(clienteService.consulta(dni) == null) {
			System.out.println("El DNI no existe");
		}else {
			service.alta(bancoid, dni, saldo);
		}
		CuentaView.printMenuPrincipal();
	}

	public void consultarCuenta(int id) {

		if(service.consulta(id) == null) {
			System.out.println("Id de cuenta no encontrado");
			CuentaView.printMenuConsulta();
		}else {
			System.out.println(service.consulta(id));
			CuentaView.printMenuPrincipal();
		}
	}

	public void borrarCuenta(int id) {

		if(service.consulta(id) == null) {
			System.out.println("Id no encontrado");
			CuentaView.printMenuBorrado();
		}else {
			System.out.println("Se ha borrado la "+ service.borrar(id)); 
			CuentaView.printMenuPrincipal();
		}
	}
	
	public void modificarSaldoCuenta(int id, double saldo) {

		if(service.consulta(id) == null) {
			System.out.println("Id no encontrado");
			CuentaView.printMenuModificar();
		}else {
			System.out.println("Se ha actualizado la "+ service.modificarSaldo(id,saldo)); 
			CuentaView.printMenuPrincipal();
		}
		
	}

	public void listarCuentas() {
		
		List<Cuenta> cuentas = service.listarCuentas();
		
		for (Cuenta cuenta : cuentas) {
			System.out.println(cuenta);
		}
		CuentaView.printMenuPrincipal();
	}
	
	public void consultarTotal(String dni) {
		
		if(clienteService.consulta(dni) == null) {
			System.out.println("El DNI no existe");
		}else {
			Double saldoTotal = service.consultarSaldoTotal(dni);
			System.out.println("El cliente con DNI "+dni+ " tiene un total de "+ String.valueOf(saldoTotal)+ " euros.");
		}
		CuentaView.printMenuPrincipal();
	}
}
