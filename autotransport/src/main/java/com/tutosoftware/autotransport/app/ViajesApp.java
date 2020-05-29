package com.tutosoftware.autotransport.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.tutosoftware.autotransport.dao.TransportistaDAO;
import com.tutosoftware.autotransport.dao.ViajeDAO;
import com.tutosoftware.autotransport.domain.Transportista;
import com.tutosoftware.autotransport.domain.Viaje;



public class ViajesApp {
	TransportistaDAO transportistaDAO = new TransportistaDAO();
	ViajeDAO viajeDAO = new ViajeDAO();
	Scanner reader = new Scanner(System.in);
	int numero;
	
	ViajesApp(){
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			/* No hacer nada */
		}
		
		menuViajes();
	}
	
	public void menuViajes() {
		
		System.out.println("************************************************************");
		System.out.println("*                                                          *");
		System.out.println("*                                                          *");
		System.out.println("* Tutosofware      Viajes      Mexican Transport           *");
		System.out.println("* El menu es el siguiente:                                 *");
		System.out.println("* 1.Insertar Viaje                                         *");
		System.out.println("* 2.Listar   Viajes                                        *");
		System.out.println("* 3.Regresar Menu Pricipal                                 *");
		System.out.println("* 4.Salir    Apilcacion                                    *");
		System.out.println("************************************************************");
		System.out.println();
		System.out.println();

		try {
			System.out.println("Introduce un numero entero y presionar enter");
			numero = reader.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("¡Cuidado! Solo puedes insertar números. ");
			reader.next();
		}
		
	
	
	
	if (numero == 1) {
		try {
			insertarViajeApp();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else if (numero == 2) {
		listarViajes();
		
	} else if (numero == 3) {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			/* No hacer nada */
		}
		Principal p = new Principal(); 
        p.menu();

	} else {
		try {

			new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
			System.exit(0);

		} catch (Exception e) {
			/* maneja tus errores aquí */
		}
	}
    }
	
	public void insertarViajeApp() throws ParseException {
		String fecha,descripcion;
		Viaje v = new Viaje();
		Transportista t = new Transportista();
		int idTransportista;
		System.out.println();
		System.out.println("Introducir ID de tu transportista y presionar Enter:");
		idTransportista = reader.nextInt();
		t = transportistaDAO.buscarTransportista(idTransportista);
		if(t.getIdTransportista() == 0) {
			reader.nextLine();
			System.out.println("No hay ese transportista con ese ID Presiona Enter para Continuar");
			reader.nextLine();
			menuViajes();
		}else {
			System.out.println("Introducir Fecha de viaje ejemplo el formato es  30-01-2020 y presionae enter");
			fecha = reader.next();
			reader.nextLine();
			System.out.println("Introducir una descripción del viaje");
			descripcion=reader.nextLine();
			
			
			java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			v.setFecha(sqlDate);
			v.setIdTransporte(t.getIdTransporte());
			v.setIdTransportista(t.getIdTransportista());
			v.setNombre(t.getNombre());
			v.setApellidoPaterno(t.getApellidoPaterno());
			v.setApellidoMaterno(t.getApellidoMaterno());
			v.setDescripcion(descripcion);
			
			viajeDAO.insertarViaje(v);
			menuViajes();
			
		}
		
	}
	
	public void listarViajes() {
		
		viajeDAO.mostrarViajes();
		reader.nextLine();
		 System.out.println("Presiona Enter para Continuar");
		 reader.nextLine();
		 menuViajes();
	}
	  
	

}
