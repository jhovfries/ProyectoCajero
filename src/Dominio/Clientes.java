package Dominio;

public class Clientes {
	private int numCuenta;
	private String nombre;
	private String correo;
	private float saldo;
	private boolean status;
	
	public Clientes(int numCuenta, String nombre, String correo, float saldo, boolean status) {
		this.numCuenta = numCuenta;
		this.nombre = nombre;
		this.correo = correo;
		this.saldo = 0;
		this.status = true;
	}

	@Override
	public String toString() {
		return "Clientes [numCuenta=" + numCuenta + ", nombre=" + nombre + ", correo=" + correo + ", saldo=" + saldo
				+ ", status=" + status + "]";
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
