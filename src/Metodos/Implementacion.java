package Metodos;

import java.util.ArrayList;
import java.util.List;


import Dominio.Clientes;
import Interface.Metodos;

public class Implementacion implements Metodos {
	private List<Clientes> lista = new ArrayList<Clientes>();
	@Override
	public boolean guardar(Clientes cliente) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		for (Clientes cl : lista) {
			if (cl.getNumCuenta()==cliente.getNumCuenta()) {
				bandera = true;
				break;
			}
			
		}
		if(bandera == false)
			lista.add(cliente);
		return bandera;
	}

	@Override
	public List<Clientes> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Clientes consulta(int numCuenta) {
		// TODO Auto-generated method stub

	    for (Clientes cl : lista) {
	        if (cl.getNumCuenta() == numCuenta) {
	            return cl;
	        }
	    }

	    return null;
	}

	@Override
	public void deposito(int numCuenta, float monto) {
		// TODO Auto-generated method stub
		 if (monto <= 0) 
			 System.out.println("El monto debe ser mayor a 0");
		    
		  Clientes cl = consulta(numCuenta);

		    if (cl != null) {
		        cl.setSaldo(cl.getSaldo() + monto);
		        System.out.println("Depósito realizado");
		    } else {
		        System.out.println("Cuenta no encontrada");
		    }
		
	}

	@Override
	public void retiro(int numCuenta, float monto) {
		// TODO Auto-generated method stub
		 if (monto <= 0) 
			 System.out.println("El monto debe ser mayor a 0");
		 Clientes cl = consulta(numCuenta);

		    if (cl != null) {

		        if (cl.getSaldo() >= monto) {
		            cl.setSaldo(cl.getSaldo() - monto);
		            System.out.println("Retiro realizado");
		        } else {
		            System.out.println("Saldo insuficiente");
		        }

		    } else {
		        System.out.println("Cuenta no encontrada");
		    }
	}

}