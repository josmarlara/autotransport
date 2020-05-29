package com.tutosoftware.autotransport.app;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.tutosoftware.autotransport.dao.TransporteDAO;
import com.tutosoftware.autotransport.domain.Transporte;



public class TransporteApp {
	
	Scanner reader = new Scanner(System.in);
	int numero;
	TransporteDAO transporteDAO = new TransporteDAO();
	
	public TransporteApp() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			/* No hacer nada */
		}
		
		menuTransporte();
		
	}
	
	public void menuTransporte() {
		
		System.out.println("************************************************************");
		System.out.println("*                                                          *");
		System.out.println("*                                                          *");
		System.out.println("* Tutosofware   TRANSPORTE        Mexican Transport        *");
		System.out.println("* El menu es el siguiente:                                 *");
		System.out.println("* 1.Insertar Transporte                                    *");
		System.out.println("* 2.Modificar  Transporte                                  *");
		System.out.println("* 3.Eliminar Transporte                                    *");
		System.out.println("* 4.Buscar  Trasporte por ID                               *");
		System.out.println("* 5.Listar Trasnsportes                                    *");
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
			insertarTransporteApp();
			
		} else if (numero == 2) {
			modificarTransporteApp();
		} else if (numero == 3) {
			eliminarTransporteApp();
			
		}else if(numero == 4){
			buscarTransporteIdApp();
			
		}else if(numero ==5) {
			listarTrasportes();
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
	
	public void insertarTransporteApp() {
		Transporte t = new Transporte();
		String matricula,marca,modelo,carga,tipoLicencia;
		
		System.out.println();
		System.out.println("Introducir Matrícula de Transporte y presionar Enter:");
		matricula = reader.next();
		System.out.println("Introducir Marca de Transporte y presionar Enter:");
		marca = reader.next();
		System.out.println("Introducir Modelo de Transporte y presionar Enter:");
		reader.nextLine();
		modelo = reader.nextLine();
		System.out.println("Introducir Capacidad de Carga del Transporte y presionar Enter:");
		carga = reader.nextLine();
		System.out.println("Introducir Tipo de Licencia del Transporte y presionar Enter:");
		tipoLicencia = reader.next();
		
		t.setMatricula(matricula);
		t.setMarca(marca);
		t.setModelo(modelo);
		t.setCarga(carga);
		t.setTipoLicencia(tipoLicencia);
		
		transporteDAO.insertarTrasporte(t);
		
		menuTransporte();
		
	}
	
	public void modificarTransporteApp() {
		
		Transporte t = new Transporte();
		Transporte tAc = new Transporte();
		String matriculaAc,marcaAc,modeloAc,cargaAc,tipoLicenciaAc,disponibilidadAc;
		int idTransporte;
		System.out.println();
		System.out.println("Introducir ID de tu transporte y presionar Enter:");
		idTransporte = reader.nextInt();
		t = transporteDAO.buscarTrasporte(idTransporte);
		if(t.getIdTrasporte() == 0) {
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			menuTransporte();
		}else {
			System.out.println("ID Trasporte: "+t.getIdTrasporte());
			System.out.println("Matrícula: "+t.getMatricula());
			System.out.println("Marca: "+t.getMarca());
			System.out.println("Modelo: "+t.getModelo());
			System.out.println("Carga: "+t.getCarga());
			System.out.println("Tipo Licencia: "+t.getTipoLicencia());
			System.out.println("Disponibilidad : "+t.getDisponibilidad());
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			System.out.println("Actualizar Matricula o presionar enter");
			matriculaAc=reader.nextLine();
			System.out.println("Actualizar Marca o presionar enter");
			marcaAc=reader.nextLine();
			System.out.println("Actualizar Modelo o presionar enter");
			modeloAc=reader.nextLine();
			System.out.println("Actualizar Carga o presionar enter");
			cargaAc=reader.nextLine();
			System.out.println("Actualizar Tipo Licencia  o presionar enter");
			tipoLicenciaAc=reader.nextLine();
			System.out.println("Actualizar Disponibilidad o presionar enter");
			disponibilidadAc=reader.nextLine();
			
			tAc.setIdTrasporte(t.getIdTrasporte());
			if(matriculaAc.isEmpty() || matriculaAc == null) {
				tAc.setMatricula(t.getMatricula());
			}else {
				tAc.setMatricula(matriculaAc);
			}
			if(marcaAc.isEmpty() || marcaAc == null) {
				tAc.setMarca(t.getMarca());
			}else {
				tAc.setMarca(marcaAc);
			}
			if(modeloAc.isEmpty() || modeloAc == null) {
				tAc.setModelo(t.getModelo());
			}else {
				tAc.setModelo(modeloAc);;
			}
			if(cargaAc.isEmpty() || cargaAc == null) {
				tAc.setCarga(t.getCarga());
			}else {
				tAc.setCarga(cargaAc);
			}
			if(tipoLicenciaAc.isEmpty() || tipoLicenciaAc == null) {
				tAc.setTipoLicencia(t.getTipoLicencia());
			}else {
				tAc.setTipoLicencia(tipoLicenciaAc);
			}
			if(disponibilidadAc.isEmpty() || disponibilidadAc == null) {
				tAc.setDisponibilidad(t.getDisponibilidad());
			}else {
				tAc.setDisponibilidad(disponibilidadAc);
			}
			
			transporteDAO.actualizarTransporte(tAc);
			
			menuTransporte();
			
		}
	}
	
	public void eliminarTransporteApp() {
		int idTransporte;
		System.out.println();
		System.out.println("Introducir ID Transporte y presionar Enter:");
		idTransporte = reader.nextInt();
		transporteDAO.eliminarTransporte(idTransporte);
		menuTransporte();
	}
	
	public void buscarTransporteIdApp() {
	
		Transporte t = new Transporte();
		int idTransporte;
		System.out.println();
		System.out.println("Introducir ID de tu transporte y presionar Enter:");
		idTransporte = reader.nextInt();
		t = transporteDAO.buscarTrasporte(idTransporte);
		if(t.getIdTrasporte() == 0) {
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			menuTransporte();
		}else {
			System.out.println("ID Trasporte: "+t.getIdTrasporte());
			System.out.println("Matrícula: "+t.getMatricula());
			System.out.println("Marca: "+t.getMarca());
			System.out.println("Modelo: "+t.getModelo());
			System.out.println("Carga: "+t.getCarga());
			System.out.println("Tipo Licencia: "+t.getTipoLicencia());
			System.out.println("Disponibilidad : "+t.getDisponibilidad());
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			menuTransporte();
			
		}
		
	}
	
	public void listarTrasportes() {
		 
	     transporteDAO.mostrarTransportes();
		
		
		reader.nextLine();
		System.out.println("Presiona Enter para Continuar");
		reader.nextLine();
		menuTransporte();
		
	}

}
