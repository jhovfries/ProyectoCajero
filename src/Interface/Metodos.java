package Interface;

import java.util.List;

import Dominio.Clientes;

public interface Metodos {
	public boolean guardar(Clientes cliente);
	public List<Clientes> mostrar();
	public Clientes consulta(int numCuenta);
	public void deposito(int numCuenta, float monto);
	public void retiro(int numCuenta, float monto);
}