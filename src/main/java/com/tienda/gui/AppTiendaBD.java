package com.tienda.gui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.tienda.bean.*;
import com.tienda.dao.*;

public class AppTiendaBD {
	public static void main(String[] args) {
		String conexion = "jdbc:sqlite:datos/tienda.db"; // Para cualquier conexion de base de datos
		DAOCompra dao = null;
		DAOProducto dao2 = new DAOImpProductoBD(conexion);
		DAOCliente dao3 = new DAOImpClienteBD(conexion);
		List<Producto> albaran = null;
		List<ItemCompra> comprado= new ArrayList<ItemCompra>(); 
		Cliente cliente = new Cliente();
		Producto producto = null;
		Compra compra = null;
		int numFac = 0;
		Scanner sc = new Scanner(System.in);
		boolean clienteComprando = true;
		boolean tiendaAbierta = true;
									
									/*TEXTO DE BIENVENIDA*/
		
		System.out.println("\n********Bienvenido a la Fruteria Pepe********\nHoy tenemos a la venta los siguientes artículos:\n");
    albaran = dao2.leerTodos();
    for (Producto p : albaran){
    	System.out.println(p);
    }
    dao2.cerrar();

    			/*VENTA*/
    while (tiendaAbierta){
	    System.out.println("\n****Datos de cliente*****");
	    System.out.print("Dni: ");
	    
			cliente.setDni(sc.nextLine());
			
			dao3.grabar(cliente);//Graba si no está almacenado en la base de datos
			dao3.cerrar();	
			while(clienteComprando) {
				System.out.print("Producto: ");
				String nombreProducto = sc.nextLine();
				System.out.print("Cantidad: ");
				double cantidad = Double.parseDouble(sc.nextLine()); 
				for (Producto p : albaran){
	    			if (p.getName().equalsIgnoreCase(nombreProducto)){
	    				comprado.add(new ItemCompra(p,cantidad));	
	    			}
	    	}
	    	System.out.println("Algo mas?S/N");
	    	if(sc.nextLine().equalsIgnoreCase("n")){// Para añadir productos a la compra
	    		clienteComprando = false;
	    	}
	    }
	    clienteComprando = true;
	    dao = new DAOImpCompraBD(conexion);	// Por la necesidad de cerrarlo por si necesito hacer insert de clientes nuevos
	    numFac = dao.enumerar();
	    compra = new Compra(cliente,comprado,numFac);
	    dao.grabar(compra);
	    dao.cerrar();//Obligado a cerrar porque necesito hacer insert de posibles nuevos clientes y el select crea conflicto
	    System.out.println("Tienda Abierta?S/N");
	    if(sc.nextLine().equalsIgnoreCase("n")){ //para atender nuevo cliente
	   		tiendaAbierta = false;
	   	}
	  }
	  dao = new DAOImpCompraBD(conexion);
	System.out.println(dao.ticket(numFac)); //Imprime ticket en este caso el ultimo registrado
    System.out.println(dao.ticket(numFac - 1));
    
    dao.cerrar();
    dao3.cerrar();
	}
}