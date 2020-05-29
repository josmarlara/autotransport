package com.tutosoftware.autotransport.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.tutosoftware.autotransport.dao.LicenciaDAO;
import com.tutosoftware.autotransport.domain.Licencia;



public class LicenciaApp {

	Scanner reader = new Scanner(System.in);
	int numero;
	
	LicenciaDAO licenciaDAO = new LicenciaDAO();

	public LicenciaApp() {

		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			/* No hacer nada */
		}

		menuLicencia();
	}

	public void menuLicencia() {

		System.out.println("************************************************************");
		System.out.println("*                                                          *");
		System.out.println("*                                                          *");
		System.out.println("* Tutosofware      LICENCIAS      Mexican Transport        *");
		System.out.println("* El menu es el siguiente:                                 *");
		System.out.println("* 1.Insertar Licencia                                      *");
		System.out.println("* 2.Modificar Licencia                                     *");
		System.out.println("* 3.Eliminar Licencia                                      *");
		System.out.println("* 4.Regresar Menu Pricipal                                 *");
		System.out.println("* 5.Salir    Apilcacion                                    *");
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
				insertarLicenciaApp();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (numero == 2) {
			try {
				modificarLicenciaApp();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (numero == 3) {
			eliminarLicenciaApp();
		} else if (numero == 4) {
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

	
	public void insertarLicenciaApp() throws ParseException {

		Licencia licencia = new Licencia();
		String idLicencia, nombre, apellidoPaterno, apellidoMaterno;
		String fechaObtencion, fechaExpiracion, tipoLetra;

		System.out.println();
		System.out.println("Introducir ID Licencia y presionar Enter:");
		idLicencia = reader.next();
		System.out.println("Introducir Nombre y presionar Enter:");
		reader.nextLine();
		nombre = reader.nextLine();
		System.out.println("Introducir Apellido Paterno y presionar Enter:");
		apellidoPaterno = reader.nextLine();
		System.out.println("Introducir Apellido Materno y presionar Enter");
		reader.nextLine();
		apellidoMaterno = reader.nextLine();
		System.out.println("Introducir Fecha de Obtencion ejemplo el formato es  30-01-2020 y presionae enter");
		fechaObtencion = reader.next();
		System.out.println("Introducir Fecha de Expiracion ejemplo el formato es  30-01-2020 y presionae enter");
		fechaExpiracion = reader.next();
		System.out.println("Introducir Tipo de Letra");
		tipoLetra = reader.next();

		java.util.Date dateObt = new SimpleDateFormat("dd-MMM-yyyy").parse(fechaObtencion);
		java.sql.Date sqlDateObt = new java.sql.Date(dateObt.getTime());
		
		
		java.util.Date dateExp = new SimpleDateFormat("dd-MMM-yyyy").parse(fechaExpiracion);
		java.sql.Date sqlDateExp = new java.sql.Date(dateExp.getTime());
		
		licencia.setIdLicencia(idLicencia);
		licencia.setNombre(nombre);
		licencia.setApellidoPaterno(apellidoPaterno);
		licencia.setApellidoMaterno(apellidoMaterno);
		licencia.setFechaObtencion(sqlDateObt);
		licencia.setFechaExpiracion(sqlDateExp);
		licencia.setTipoLetra(tipoLetra);

		licenciaDAO.insertarLicencia(licencia);
		menuLicencia();
	}
	
	public void modificarLicenciaApp() throws ParseException {
		Licencia licencia = new Licencia();
		Licencia licAct = new Licencia();
		String nombreAc,apellidoPaternoAc,apellidoMaternoAc,fechaObtAc,fechaExpAc,tipoLetraAc;
		String idLicencia;
		System.out.println();
		System.out.println("Introducir ID Licencia y presionar Enter:");
		idLicencia = reader.next();
		licencia = licenciaDAO.buscarLicencia(idLicencia);
		if(licencia.getIdLicencia() == null) {
			reader.nextLine();
			System.out.println("Presiona Enter para Continuar");
			reader.nextLine();
			menuLicencia();
		}else {
		System.out.println("ID Licencia: "+licencia.getIdLicencia());
		System.out.println("Nombre: "+licencia.getNombre());
		System.out.println("Apellido Paterno: "+licencia.getApellidoPaterno());
		System.out.println("Apellido Materno: "+licencia.getApellidoMaterno());
		System.out.println("Fecha de Obtención: "+licencia.getFechaObtencion());
		System.out.println("Fecha de Expiración: "+licencia.getFechaExpiracion());
		System.out.println("Tipo de Letra : "+licencia.getTipoLetra());
		reader.nextLine();
		System.out.println("Presiona Enter para Continuar");
		reader.nextLine();
		System.out.println("Actualizar Nombre o presionar enter");
		nombreAc=reader.nextLine();
		System.out.println("Actualizar Apellido Paterno o presionar enter");
		apellidoPaternoAc=reader.nextLine();
		System.out.println("Actualizar Apellido Materno o presionar enter");
		apellidoMaternoAc=reader.nextLine();
		System.out.println("Actualizar Fecha de Obtención dd-mm-yyyy o presionar enter");
		fechaObtAc=reader.nextLine();
		System.out.println("Actualizar Fecha de Expedición dd-mm-yyyy o presionar enter");
		fechaExpAc=reader.nextLine();
		System.out.println("Actualizar tipo de letra o presionar enter");
		tipoLetraAc=reader.nextLine();
		licAct.setIdLicencia(licencia.getIdLicencia());
		if(nombreAc.isEmpty() || nombreAc == null) {
			licAct.setNombre(licencia.getNombre());
		}else {
			licAct.setNombre(nombreAc);
		}
		if(apellidoPaternoAc.isEmpty() || apellidoPaternoAc == null) {
			licAct.setApellidoPaterno(licencia.getApellidoPaterno());
		}else {
			licAct.setApellidoPaterno(apellidoPaternoAc);
		}
		if(apellidoMaternoAc.isEmpty() || apellidoMaternoAc == null) {
			licAct.setApellidoMaterno(licencia.getApellidoMaterno());
		}else {
			licAct.setApellidoMaterno(apellidoMaternoAc);
		}
		if(fechaObtAc.isEmpty() || fechaObtAc == null) {
			licAct.setFechaObtencion(licencia.getFechaObtencion());
		}else {
			java.util.Date dateObt = new SimpleDateFormat("dd-MM-yyyy").parse(fechaObtAc);
			java.sql.Date sqlDateObt = new java.sql.Date(dateObt.getTime());
			licAct.setFechaObtencion(sqlDateObt);
		}
		if(fechaExpAc.isEmpty()  || fechaExpAc == null) {
			licAct.setFechaExpiracion(licencia.getFechaExpiracion());
		}else {
			java.util.Date dateExp = new SimpleDateFormat("dd-MM-yyyy").parse(fechaExpAc);
			java.sql.Date sqlDateExp = new java.sql.Date(dateExp.getTime());
			licAct.setFechaExpiracion(sqlDateExp);
		}
		if(tipoLetraAc.isEmpty() || tipoLetraAc == null) {
			licAct.setTipoLetra(licencia.getTipoLetra());
		}else {
			licAct.setTipoLetra(tipoLetraAc);
		}
		
		licenciaDAO.actualizarLicencia(licAct);
		
		menuLicencia();
		}
	}
	
	public void eliminarLicenciaApp() {
		
		String idLicencia;
		System.out.println();
		System.out.println("Introducir ID Licencia y presionar Enter:");
		idLicencia = reader.next();
		licenciaDAO.eliminarLicencia(idLicencia);
		menuLicencia();
		
	}
	

}
