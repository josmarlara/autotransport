package com.tutosoftware.autotransport.domain;

public class Transporte {
	
	private int idTrasporte;
	private String matricula;
	private String marca;
	private String modelo;
	private String carga;
	private String tipoLicencia;
	private String disponibilidad;
	public int getIdTrasporte() {
		return idTrasporte;
	}
	public void setIdTrasporte(int idTrasporte) {
		this.idTrasporte = idTrasporte;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCarga() {
		return carga;
	}
	public void setCarga(String carga) {
		this.carga = carga;
	}
	public String getTipoLicencia() {
		return tipoLicencia;
	}
	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
