package mvc.model.service;

import java.util.List;

import mvc.model.dao.CuentaDAO;
import mvc.model.entity.Cuenta;
import mvc.model.entity.Banco;
import mvc.model.entity.Cliente;


public class CuentaService {

	private BancoService bancoService = new BancoService();
	private ClienteService clienteService = new ClienteService();
	private CuentaDAO dao =  new CuentaDAO();
	
	public void alta(int idCuenta, String dni, double saldo) {
		
		Banco banco = bancoService.consulta(idCuenta);
		Cliente cliente = clienteService.consulta(dni);
		Cuenta cuenta = Cuenta.builder().banco(banco).cliente(cliente).saldo(saldo).build();
		dao.create(cuenta);
	}

	public Cuenta consulta(int id) {
		
		return dao.read(id);
	}
	
	public Cuenta borrar(int id) {
		Cuenta cuenta = dao.read(id);
		dao.delete(cuenta);
		return cuenta;
	}
	
	public Cuenta modificarSaldo(int id, double nuevoSaldo) {
		Cuenta cuenta = dao.read(id);
		cuenta.setSaldo(nuevoSaldo);
		dao.update(cuenta);
		return cuenta;
	}
	
	public List<Cuenta> listarCuentas(){
		return dao.readAll();
	}
	
	public double consultarSaldoTotal(String dni) {
		
		List<Cuenta> cuentas = dao.readAll();
		double saldoTotal = 0;
		
		for (Cuenta cuenta : cuentas) {
			if(cuenta.getCliente().getDni().equals(dni)) {
				saldoTotal += cuenta.getSaldo();
			}	
		}

		return saldoTotal;
		
	}
	
}
