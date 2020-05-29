package com.tutosoftware.autotransport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tutosoftware.autotransport.domain.Transportista;
import com.tutosoftware.autotransport.util.DataConnect;




public class TransportistaDAO {
	
	public void insertarTransportista(Transportista t) {
		
		Connection cn;
		Statement st;
		
		
       try {
			
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql,tsql2;
			
			
			tsql = " insert into transportista values(null,"+t.getIdTransporte()+",";
			tsql+= "'"+t.getIdLicencia()+"',";
			tsql+= "'"+t.getNombre()+"',";
			tsql+= "'"+t.getApellidoPaterno()+"',";
			tsql+= "'"+t.getApellidoMaterno()+"',";
			tsql+= "'"+t.getTelefono()+"') ";
			
			tsql2 = " update transporte set disponibilidad = 'Ocupado' where idTransporte= "+t.getIdTransporte();
			
			
			
			st.execute(tsql);
			st.execute(tsql2);
			cn.close();
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	public Transportista buscarTransportista(int idTransportista) {
		  
		  
		  Connection cn = null;
			Transportista t = new Transportista();
			Statement st;
			ResultSet rs;
			
			
			try{
				cn = DataConnect.getConnection();
				st = cn.createStatement();
				String tsql = "Select * from transportista where idTransportista = "+idTransportista;
				rs = st.executeQuery(tsql);
				if(!rs.next()) {
					System.out.println("No hay trasportistas disponibles");
				}else {
				t.setIdTransportista(rs.getInt("idTransportista"));
				t.setIdTransporte(rs.getInt("idTransporte"));
				t.setIdLicencia(rs.getString("idlicencia"));
				t.setNombre(rs.getString("nombre"));
				t.setApellidoPaterno(rs.getString("apellidoPaterno"));
				t.setApellidoMaterno(rs.getString("apellidoMaterno"));
				t.setTelefono(rs.getString("telefono"));
				}
				cn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return t;
	  }
	
	public void actualizarTrasportista(Transportista t) {
		
		Connection cn;
 		Statement st;
 		
 		
 		try {
 			
 			cn = DataConnect.getConnection();
 			st = cn.createStatement();
 			String tsql;
 			
 			
 			tsql = " update transportista set nombre ='"+t.getNombre()+"',";
 			tsql+= "apellidoPaterno ='"+t.getApellidoPaterno()+"',";
 			tsql+= "apellidoMaterno ='"+t.getApellidoMaterno()+"',";
 			tsql+= "telefono ='"+t.getTelefono()+"' where idTransportista="+t.getIdTransportista();
 			
 			
           
          
 			
 			
 			st.execute(tsql);
 			cn.close();
 			
 			
 			
 		}catch(Exception e) {
 			
 			e.printStackTrace();
 			
 		}
	}
	
	public void eliminarTransportista(int idTransportista) {
		 Connection cn;
	  		Statement st;
	  		
	  		
	  		try {
	  			
	  			cn = DataConnect.getConnection();
	  			st = cn.createStatement();
	  			String tsql;
	  			
	  			
	  			tsql = "delete from transportista where idTransportista = "+idTransportista;
	  			
	  			
	  			


	  			
	  			
	  			st.execute(tsql);
	  			cn.close();
	  			
	  			
	  			
	  		}catch(Exception e) {
	  			
	  			e.printStackTrace();
	  			
	  		}
	}
	
	 public void mostrarTransportistas() {
		  
		 Connection cn = null;
			
			
			Statement st;
			ResultSet rs;
			try{
				cn = DataConnect.getConnection();
				st = cn.createStatement();
				String tsql = "Select * from transportista";
				rs = st.executeQuery(tsql);
				
					System.out.println("IDTransportista  IDTransporte   Licencia   Nombre   ApellidoPaterno    ApellidoMaterno  Telefono    ");				
					while(rs.next()){
					
					System.out.println(rs.getInt("idTransportista")+"      "+rs.getInt("idTransporte")+"    "+rs.getString("idlicencia")+"      "+rs.getString("nombre")+"      "+rs.getString("apellidoPaterno")+"      "+rs.getString("apellidoMaterno")+"     "+rs.getString("telefono"));
					
					}
				
				cn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		  
	  }
	 
	 

 }

 









