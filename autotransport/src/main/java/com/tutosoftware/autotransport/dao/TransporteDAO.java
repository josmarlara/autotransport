package com.tutosoftware.autotransport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tutosoftware.autotransport.domain.Transporte;
import com.tutosoftware.autotransport.util.DataConnect;




public class TransporteDAO {
	
	public void insertarTrasporte(Transporte t) {
		
		Connection cn;
		Statement st;
		
		
try {
			
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql;
			
			
			tsql = " insert into transporte values(null,'"+t.getMatricula()+"',";
			tsql+= "'"+t.getMarca()+"',";
			tsql+= "'"+t.getModelo()+"',";
			tsql+= "'"+t.getCarga()+"',";
			tsql+= "'"+t.getTipoLicencia()+"',";
			tsql+= "'Disponible')";
			
			
			
			
			
			st.execute(tsql);
			cn.close();
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	
	public Transporte buscarTrasporte(int idTransporte) {
		Connection cn = null;
		Transporte t = new Transporte();
		Statement st;
		ResultSet rs;
		
		
		try{
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql = "Select * from transporte where idTransporte = "+idTransporte;
			rs = st.executeQuery(tsql);
			if(!rs.next()) {
				System.out.println("No hay trasportes disponibles");
			}else {
			t.setIdTrasporte(rs.getInt("idTransporte"));
			t.setMatricula(rs.getString("matricula"));
			t.setMarca(rs.getString("marca"));
			t.setModelo(rs.getString("modelo"));
			t.setCarga(rs.getString("carga"));
			t.setTipoLicencia(rs.getString("tipoLicencia"));
			t.setDisponibilidad(rs.getString("disponibilidad"));
			}
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return t;
	}
	
	public Transporte buscarTrasporte(int idTransporte,String tipoLicencia) {
		Connection cn = null;
		Transporte t = new Transporte();
		Statement st;
		ResultSet rs;
		
		
		try{
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql = "Select * from transporte where idTransporte = "+idTransporte+ " and tipoLicencia ='"+tipoLicencia+"' ";
			tsql +=" and disponibilidad = 'Disponible' ";
			
			
			//System.out.println(tsql);
			
			
			rs = st.executeQuery(tsql);
			if(!rs.next()) {
				System.out.println("No hay trasportes disponibles");
			}else {
			t.setIdTrasporte(rs.getInt("idTransporte"));
			t.setMatricula(rs.getString("matricula"));
			t.setMarca(rs.getString("marca"));
			t.setModelo(rs.getString("modelo"));
			t.setCarga(rs.getString("carga"));
			t.setTipoLicencia(rs.getString("tipoLicencia"));
			t.setDisponibilidad(rs.getString("disponibilidad"));
			}
			
			
			
			
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return t;
	}
	
	
	
	public void actualizarTransporte(Transporte t) {
		Connection cn;
 		Statement st;
 		
 		
 		try {
 			
 			cn = DataConnect.getConnection();
 			st = cn.createStatement();
 			String tsql;
 			
 			
 			tsql = " update transporte set matricula ='"+t.getMatricula()+"',";
 			tsql+= "marca ='"+t.getMarca()+"',";
 			tsql+= "modelo ='"+t.getModelo()+"',";
 			tsql+= "carga ='"+t.getCarga()+"',";
 			tsql+= "tipoLicencia ='"+t.getTipoLicencia()+"',";
 			tsql+= "disponibilidad ='"+t.getDisponibilidad()+"' where idTransporte="+t.getIdTrasporte();
 			
 			

          
 			
 			
 			st.execute(tsql);
 			cn.close();
 			
 			
 			
 		}catch(Exception e) {
 			
 			e.printStackTrace();
 			
 		}
		
	}
	
	public void eliminarTransporte(int idTransporte) {
		 Connection cn;
	  		Statement st;
	  		
	  		
	  		try {
	  			
	  			cn = DataConnect.getConnection();
	  			st = cn.createStatement();
	  			String tsql;
	  			
	  			
	  			tsql = "delete from transporte where idTransporte = "+idTransporte;
	  			
	  			
	  			


	  			
	  			
	  			st.execute(tsql);
	  			cn.close();
	  			
	  			
	  			
	  		}catch(Exception e) {
	  			
	  			e.printStackTrace();
	  			
	  		}
	}
	
	public void mostrarTransportes(){
		
		Connection cn = null;
		
		
		Statement st;
		ResultSet rs;
		try{
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql = "Select * from transporte";
			rs = st.executeQuery(tsql);
			
				System.out.println("IDTransporte  Matricula   Marca   Modelo          Carga       TipoLicencia  Dsiponibilidad    ");				
				while(rs.next()){
				
				System.out.println(rs.getInt("idTransporte")+"      "+rs.getString("matricula")+"    "+rs.getString("marca")+"      "+rs.getString("modelo")+"      "+rs.getString("carga")+"      "+rs.getString("tipoLicencia")+"     "+rs.getString("disponibilidad"));
				
				}
			
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		


		
	}
	
	
	public int mostrarTransportePorTipoLicenciaDisponibilidad(String tipoLicencia) {
		
Connection cn = null;
		
		int bandera=0;
		Statement st;
		ResultSet rs;
		try{
			cn = DataConnect.getConnection();
			st = cn.createStatement();
			String tsql = "Select * from transporte where tipoLicencia= '"+tipoLicencia+"' and disponibilidad= 'Disponible' ";
			rs = st.executeQuery(tsql);
			
				System.out.println("IDTransporte  Matricula   Marca   Modelo          Carga       TipoLicencia  Dsiponibilidad    ");				
				while(rs.next()){
				
				System.out.println(rs.getInt("idTransporte")+"      "+rs.getString("matricula")+"    "+rs.getString("marca")+"      "+rs.getString("modelo")+"      "+rs.getString("carga")+"      "+rs.getString("tipoLicencia")+"     "+rs.getString("disponibilidad"));
				++bandera;
				}
			
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return bandera;
		
	}

}
