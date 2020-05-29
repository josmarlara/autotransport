package com.tutosoftware.autotransport.domain;

public class Transportista {
	
	int idTransportista;
	int idTransporte;
	String idLicencia;
	String nombre;
	String apellidoPaterno;
	String apellidoMaterno;
	String telefono;
	public int getIdTransportista() {
		return idTransportista;
	}
	public void setIdTransportista(int idTransportista) {
		this.idTransportista = idTransportista;
	}
	public int getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	public String getIdLicencia() {
		return idLicencia;
	}
	public void setIdLicencia(String idLicencia) {
		this.idLicencia = idLicencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
