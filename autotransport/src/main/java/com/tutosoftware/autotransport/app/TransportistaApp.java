package com.tutosoftware.autotransport.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.tutosoftware.autotransport.dao.LicenciaDAO;
import com.tutosoftware.autotransport.dao.TransporteDAO;
import com.tutosoftware.autotransport.dao.TransportistaDAO;
import com.tutosoftware.autotransport.domain.Licencia;
import com.tutosoftware.autotransport.domain.Transporte;
import com.tutosoftware.autotransport.domain.Transportista;



public class TransportistaApp {
	
	Scanner reader = new Scanner(System.in);
	int numero;
	LicenciaDAO licenciaDAO = new LicenciaDAO();
	TransporteDAO transporteDAO = new TransporteDAO();
	TransportistaDAO transportistaDAO = new TransportistaDAO();
	
	public TransportistaApp() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			/* No hacer nada */
		}
		menuTransportista();
	}
	
	public void menuTransportista() {
		
		System.out.println("************************************************************");
		System.out.println("*                                                          *");
		System.out.println("*                                                          *");
		System.out.println("* Tutosofware   TRANSPORTISTA        Mexican Transport     *");
		System.out.println("* El menu es el siguiente:                                 *");
		System.out.println("* 1.Insertar Transportista                                 *");
		System.out.println("* 2.Modificar  Transportista                               *");
		System.out.println("* 3.Eliminar Transportista                                 *");
		System.out.println("* 4.Buscar  Transportista por ID                           *");
		System.out.println("* 5.Listar Transportistas                                  *");
		System.out.println("* 6.Regresar a menú principal                              *");
		System.out.println("* 7.Salir aplicación                                       *");
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
			
			insertarTransportistaApp();
			
		} else if (numero == 2) {
			modificarTransportistaApp();
		
		} else if (numero == 3) {
			eliminarTransportistaApp();
		}else if(numero == 4){
			buscarTransportistaPorIdApp();
			
		}else if(numero ==5) {
			listarTransportistas();
		}else if (numero == 6) {
		
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
	
	/****************************************************************************
	 * Para insertar un transportista primero debe tener registrada su licencia
	 * como requisito obligatorio y luego para buscaarle asignar un transporte
	 * de acuerdo a su tipo de licencia sino cumple esos características no se puede
	 * registrar el transportista
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void insertarTransportistaApp() {
		Transporte t = new Transporte();
		Licencia licencia = new Licencia();
		Transportista tr = new Transportista();
		String idLicencia,telefono;
		System.out.println();
		System.out.println("Introducir ID Licencia registrado y presionar Enter:");
		idLicencia = reader.next();
		licencia = licenciaDAO.buscarLicencia(idLicencia);
		if(licencia.getIdLicencia() == null) {
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			menuTransportista();
		}else {
			int verificaRegistros;
			verificaRegistros = transporteDAO.mostrarTransportePorTipoLicenciaDisponibilidad(licencia.getTipoLetra());
			if(verificaRegistros == 0) {
			
			reader.nextLine();
			System.out.println("No hay transportes Presiona Enter para Continuar");
			reader.nextLine();
			menuTransportista();
			}else {
				
				
				int idTransporte;
				System.out.println();
				System.out.println("Introducir ID de tu transporte y presionar Enter:");
				idTransporte = reader.nextInt();
				t = transporteDAO.buscarTrasporte(idTransporte,licencia.getTipoLetra());
				
				if(t.getIdTrasporte() == 0) {
					reader.nextLine();
					System.out.println("El transporte no existe Presiona Enter para Continuar");
					reader.nextLine();
					menuTransportista();
				}else {
					
					System.out.println("Introduce número telefonico y presiona enter");
					telefono = reader.next();
					
					tr.setIdTransporte(t.getIdTrasporte());
					tr.setIdLicencia(licencia.getIdLicencia());
					tr.setNombre(licencia.getNombre());
					tr.setApellidoPaterno(licencia.getApellidoPaterno());
					tr.setApellidoMaterno(licencia.getApellidoMaterno());
					tr.setTelefono(telefono);
					transportistaDAO.insertarTransportista(tr);
					menuTransportista();
					
				}
				
				
				
			}
		}
		
	}
	
	
	
	/* 
	 * Para la actualización del transportisa nada mas se va a modificar
	 * NOMBRE,APELLDO PATERNO,APELLIDO MATERNO y TELEFONO por
	 * que si modifcamos la licencia y transporte tendriamos que
	 * validar y eso haria mas compleja la pantalla de captura
	 * 
	 * para poder modifcar licencia y transporte se debe eliminar
	 * el transportis y volverlo a capturar.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public void modificarTransportistaApp() {
		Transportista t = new Transportista();
		Transportista tAc = new Transportista();
		String nombreAc,apellidoPaternoAc,apellidoMaternoAc,telefonoAc;
		int idTransportista;
		System.out.println();
		System.out.println("Introducir ID de tu transportista y presionar Enter:");
		idTransportista = reader.nextInt();
		t = transportistaDAO.buscarTransportista(idTransportista);
		if(t.getIdTransportista() == 0) {
			reader.nextLine();
			System.out.println("No hay ese transportista con ese ID Presiona Enter para Continuar");
			reader.nextLine();
			menuTransportista();
		}else {
			
			System.out.println("ID Trasportista: "+t.getIdTransportista());
			System.out.println("ID trasporte: "+t.getIdTransporte());
			System.out.println("ID Licencia: "+t.getIdLicencia());
			System.out.println("Nombre: "+t.getNombre());
			System.out.println("Apellido Paterno: "+t.getApellidoPaterno());
			System.out.println("Apellido Materno: "+t.getApellidoMaterno());
			System.out.println("Telefono : "+t.getTelefono());
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			System.out.println("Actualizar Nombre o presionar enter");
			nombreAc=reader.nextLine();
			System.out.println("Actualizar Apellido Paterno o presionar enter");
			apellidoPaternoAc=reader.nextLine();
			System.out.println("Actualizar Apellido Materno o presionar enter");
			apellidoMaternoAc=reader.nextLine();
			System.out.println("Actualizar telefono o presionar enter");
			telefonoAc=reader.nextLine();
			
			tAc.setIdTransportista(t.getIdTransportista());
			if(nombreAc.isEmpty() || nombreAc == null) {
				tAc.setNombre(t.getNombre());
			}else {
				tAc.setNombre(nombreAc);
			}
			if(apellidoPaternoAc.isEmpty() || apellidoPaternoAc == null) {
				tAc.setApellidoPaterno(t.getApellidoPaterno());
			}else {
				tAc.setApellidoPaterno(apellidoPaternoAc);
			}
			if(apellidoMaternoAc.isEmpty() || apellidoMaternoAc == null) {
				tAc.setApellidoMaterno(t.getApellidoMaterno());
			}else {
				tAc.setApellidoMaterno(apellidoMaternoAc);
			}
			if(telefonoAc.isEmpty() || telefonoAc == null) {
				tAc.setTelefono(t.getTelefono());
			}else {
				tAc.setTelefono(telefonoAc);
			}
			
			transportistaDAO.actualizarTrasportista(tAc);
			
			menuTransportista();
			
			
		}
			
			
			
			
	}
	
	public void eliminarTransportistaApp() {
		
		int idTransportista;
		System.out.println();
		System.out.println("Introducir ID Transportista y presionar Enter:");
		idTransportista = reader.nextInt();
		transportistaDAO.eliminarTransportista(idTransportista);
		menuTransportista();
		
	}
	
	
	public void buscarTransportistaPorIdApp() {
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
			menuTransportista();
		}else {
			
			System.out.println("ID Trasportista: "+t.getIdTransportista());
			System.out.println("ID trasporte: "+t.getIdTransporte());
			System.out.println("ID Licencia: "+t.getIdLicencia());
			System.out.println("Nombre: "+t.getNombre());
			System.out.println("Apellido Paterno: "+t.getApellidoPaterno());
			System.out.println("Apellido Materno: "+t.getApellidoMaterno());
			System.out.println("Telefono : "+t.getTelefono());
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			menuTransportista();
		}
	
		
	}
	
	public void listarTransportistas() {
		 transportistaDAO.mostrarTransportistas();
		 reader.nextLine();
		 System.out.println("Presiona Enter para Continuar");
		 reader.nextLine();
		 menuTransportista();
	 }
	
		
		
}


