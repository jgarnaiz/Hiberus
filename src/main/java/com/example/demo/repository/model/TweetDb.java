package com.example.demo.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;

@Entity
@Builder
public class TweetDb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "usuario", nullable = false)
	private String usuario;

	@Column(name = "texto", nullable = false)
	private String texto;

	@Column(name = "localizacion", nullable = true)
	private String localizacion;

	@Column(name = "validacion", nullable = false)
	private boolean validacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public boolean isValidacion() {
		return validacion;
	}

	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}

	public TweetDb() {

	}

	public TweetDb(Integer id, String usuario, String texto, String localizacion, boolean validacion) {
		this.id = id;
		this.usuario = usuario;
		this.texto = texto;
		this.localizacion = localizacion;
		this.validacion = validacion;
	}
}
