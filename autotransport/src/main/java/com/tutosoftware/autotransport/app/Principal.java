package com.tutosoftware.autotransport.app;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	
	Scanner reader = new Scanner(System.in);
	int numero;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Principal p = new Principal();
		p.menu();
		
	}
	
	public  void menu() {
		
		
		
		System.out.println("************************************************************");
		System.out.println("*                                                          *");
		System.out.println("*                                                          *");
		System.out.println("* Tutosofware            Mexican Transport                 *");
		System.out.println("* El menu es el siguiente:                                 *");
		System.out.println("* 1.Transportista                                          *");
		System.out.println("* 2.Licencia                                               *");
		System.out.println("* 3.Transporte                                             *");
		System.out.println("* 4.Viajes                                                 *");
		System.out.println("* 5.Salir                                                  *");
		System.out.println("************************************************************");
		System.out.println();
		System.out.println();
		
		
		try {
			System.out.println("Introduce un numero entero y presionar enter");
			numero=reader.nextInt();
		}catch(InputMismatchException ime) {
			System.out.println("¡Cuidado! Solo puedes insertar números. ");
		    reader.next();
		}
		
	    
		if(numero == 1) {
			TransportistaApp transportistaApp = new TransportistaApp(); 
		}
		else if(numero == 2) {
			LicenciaApp licenciaApp = new LicenciaApp();
		}
		else if(numero == 3) {
			TransporteApp transporteApp = new TransporteApp();
		}
		else if(numero == 4) {
			ViajesApp viajeApp = new ViajesApp();
		}
		else{
			try{

				  new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
				  System.exit(0);


				}catch(Exception e){
				  /*maneja tus errores aquí*/
				}
		}
		    
		
		
       

		
		
		
	}
			
		

		
		
		
		
		
	}


