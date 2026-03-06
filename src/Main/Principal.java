package Main;

import java.util.Scanner;

import Dominio.Clientes;
import Metodos.Implementacion;

public class Principal {
	@SuppressWarnings("resource")
    public static void main(String[] args) {

        Scanner lectura =  new Scanner(System.in);
        
        Implementacion imp = new Implementacion();

        int menu, numCuenta;
        String nombre, correo;
        float monto;
        
        Clientes cliente = null;

        do {
        	System.out.println("\n---HOLA, ESTE ES TU CAJERO AUTOMATICO ---");
            System.out.println("\n--- PARA REALIZAR UNA ACCION INGRESA EL NUMERO QUE CORRESPONDA ---");
            System.out.println("1---- ALTA CLIENTE");
            System.out.println("2---- CONSULTA SALDO");
            System.out.println("3---- DEPOSITO EN EFECTIVO");
            System.out.println("4---- RETIRO EN EFECTIVO");
            System.out.println("5---- SALIR");
            
            menu = lectura.nextInt();

            switch (menu) {
        case 1:
            try {
                    System.out.println("Ingresa numero de cuenta:");
                    numCuenta = lectura.nextInt();
                    lectura.nextLine(); 

                    System.out.println("Ingresa nombre:");
                    nombre = lectura.nextLine();

                    System.out.println("Ingresa correo:");
                    correo = lectura.nextLine();

                    cliente = new Clientes(numCuenta, nombre, correo, 0, true);

                   boolean respuesta = imp.guardar(cliente);
                   if(respuesta==true)
                		System.out.println("Ya existe ese registro");
                   else
                    System.out.println("Cliente registrado correctamente");
                } catch (Exception e) {
                	System.out.println("Error");
                }
            break;

                case 2:
                    System.out.println("Ingresa numero de cuenta:");
                    numCuenta = lectura.nextInt();

                    Clientes c = imp.consulta(numCuenta);

                    if (c != null) {
                        System.out.println("Saldo actual: $" + c.getSaldo());
                    } else {
                        System.out.println("Cuenta no encontrada");
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Ingresa numero de cuenta:");
                        numCuenta = lectura.nextInt();

                        Clientes client = imp.consulta(numCuenta);

                        if (client != null) {

                            System.out.println("Ingresa monto a depositar:");
                            monto = lectura.nextFloat();

                            if (monto > 0) {
                                imp.deposito(numCuenta, monto);
                            } else {
                                System.out.println("El monto debe ser mayor a 0");
                            }

                        } else {
                            System.out.println("Cuenta no encontrada");
                        }

                    } catch (Exception e) {
                        System.out.println("Error en el deposito");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Ingresa numero de cuenta:");
                        numCuenta = lectura.nextInt();

                        Clientes cli = imp.consulta(numCuenta);

                        if (cli != null) {

                            System.out.println("Ingresa monto a retirar:");
                            monto = lectura.nextFloat();

                            if (monto > 0) {

                                if (cli.getSaldo() >= monto) {
                                    imp.retiro(numCuenta, monto);
                                } else {
                                    System.out.println("Saldo insuficiente");
                                }

                            } else {
                                System.out.println("El monto debe ser mayor a 0");
                            }

                        } else {
                            System.out.println("Cuenta no encontrada");
                        }

                    } catch (Exception e) {
                        System.out.println("Error en el retiro");
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opcion invalida");
                }

        

        } while (menu < 5);
    }
}