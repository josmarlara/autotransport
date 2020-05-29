package com.tutosoftware.autotransport.domain;

import java.sql.Date;

public class Licencia {
	
	private String idLicencia;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaObtencion;
    private Date fechaExpiracion;
    private String tipoLetra;
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
	public Date getFechaObtencion() {
		return fechaObtencion;
	}
	public void setFechaObtencion(Date fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
	}
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public String getTipoLetra() {
		return tipoLetra;
	}
	public void setTipoLetra(String tipoLetra) {
		this.tipoLetra = tipoLetra;
	}
}
