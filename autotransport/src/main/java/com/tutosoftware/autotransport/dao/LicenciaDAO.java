package com.tutosoftware.autotransport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tutosoftware.autotransport.domain.Licencia;
import com.tutosoftware.autotransport.util.DataConnect;



public class LicenciaDAO {
	
	
	public void insertarLicencia(Licencia licencia) {
		// TODO Auto-generated method stub
		
		Connection cn;
		Statement st;
		
		
		try {
			
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql;
			
			
			tsql = " insert into licencia values('"+licencia.getIdLicencia()+"',";
			tsql+= "'"+licencia.getNombre()+"',";
			tsql+= "'"+licencia.getApellidoPaterno()+"',";
			tsql+= "'"+licencia.getApellidoMaterno()+"',";
			tsql+= "'"+licencia.getFechaObtencion()+"',";
			tsql+= "'"+licencia.getFechaExpiracion()+"',";
			tsql+= "'"+licencia.getTipoLetra()+"')";
			
			
			
			
			
			st.execute(tsql);
			cn.close();
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		

	}
	
	public Licencia buscarLicencia(String idLicencia) {
		Connection cn = null;
		Licencia licencia = new Licencia();
		Statement st;
		ResultSet rs;
		
		
		try{
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql = "Select * from licencia where idlicencia = '"+idLicencia+"'";
			rs = st.executeQuery(tsql);
			if(!rs.next()) {
				System.out.println("No hay licencias disponibles con ese ID");
			}else {
			licencia.setIdLicencia(rs.getString("idlicencia"));
			licencia.setNombre(rs.getString("nombre"));
			licencia.setApellidoPaterno(rs.getString("apellidoPaterno"));
			licencia.setApellidoMaterno(rs.getString("apellidoMaterno"));
			licencia.setFechaObtencion(rs.getDate("fechaObtencion"));
			licencia.setFechaExpiracion(rs.getDate("fechaExpiracion"));
			licencia.setTipoLetra(rs.getString("tipoLetra"));
			}
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return licencia;
	}
	
     public void actualizarLicencia(Licencia licencia) {
    	 Connection cn;
 		Statement st;
 		
 		
 		try {
 			
 			cn = DataConnect.getConnection();
 			st = cn.createStatement();
 			String tsql;
 			
 			
 			tsql = " update licencia set nombre ='"+licencia.getNombre()+"',";
 			tsql+= "apellidoPaterno ='"+licencia.getApellidoPaterno()+"',";
 			tsql+= "apellidoMaterno ='"+licencia.getApellidoMaterno()+"',";
 			tsql+= "fechaObtencion ='"+licencia.getFechaObtencion()+"',";
 			tsql+= "fechaExpiracion ='"+licencia.getFechaExpiracion()+"',";
 			tsql+= "tipoLetra ='"+licencia.getTipoLetra()+"' where idlicencia='"+licencia.getIdLicencia()+"'";
 			
 			


 			
 			
 			st.execute(tsql);
 			cn.close();
 			
 			
 			
 		}catch(Exception e) {
 			
 			e.printStackTrace();
 			
 		}
     }
     
     public void eliminarLicencia(String idLicencia) {
    	 
    	 Connection cn;
  		Statement st;
  		
  		
  		try {
  			
  			cn = DataConnect.getConnection();
  			st = cn.createStatement();
  			String tsql;
  			
  			
  			tsql = "delete from licencia where idlicencia ='"+idLicencia+"' ";
  			
  			
  			


  			
  			
  			st.execute(tsql);
  			cn.close();
  			
  			
  			
  		}catch(Exception e) {
  			
  			e.printStackTrace();
  			
  		}
    	 
    	 
     }
     
     
}
