package com.tutosoftware.autotransport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tutosoftware.autotransport.domain.Viaje;
import com.tutosoftware.autotransport.util.DataConnect;



public class ViajeDAO {
	
	
	public void insertarViaje(Viaje v) {
		
		Connection cn;
		Statement st;
		
		
       try {
			
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql;
			
			
			tsql = " insert into viajes values(null,'"+v.getFecha()+"',";
			tsql+= ""+v.getIdTransporte()+",";
			tsql+= ""+v.getIdTransportista()+",";
			tsql+= "'"+v.getNombre()+"',";
			tsql+= "'"+v.getApellidoPaterno()+"',";
			tsql+= "'"+v.getApellidoMaterno()+"',";
			tsql+= "'"+v.getDescripcion()+"') ";
			
		
			System.out.println(tsql);
			
			
			st.execute(tsql);
			
			cn.close();
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	public void mostrarViajes() {
		
		 Connection cn = null;
			
			
			Statement st;
			ResultSet rs;
			try{
				cn = DataConnect.getConnection();
				st = cn.createStatement();
				String tsql = "Select * from viajes";
				rs = st.executeQuery(tsql);
				
					
					while(rs.next()){
					
					System.out.println("ID viaje: "+rs.getInt("idViaje"));
					System.out.println("Fecha: "+rs.getDate("fecha"));
					System.out.println("ID Transporte: "+rs.getInt("idTransporte"));
					System.out.println("ID Transportista: "+rs.getInt("idTransportista"));
					System.out.println("Nombre: "+rs.getString("nombre"));
					System.out.println("Apellido Paterno: "+rs.getString("apellidoPaterno"));
					System.out.println("Apellido Materno: "+rs.getString("apellidoMaterno"));
					System.out.println("Descripción: "+rs.getString("descripcion"));
					
					}
				
				cn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		  
	  }
	}


