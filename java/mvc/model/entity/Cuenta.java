package mvc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cuentas")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private double saldo;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Banco banco;

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", cliente=" + cliente.getDni() + ", banco=" + banco.getNombre() + "]";
	}
	
	

}
