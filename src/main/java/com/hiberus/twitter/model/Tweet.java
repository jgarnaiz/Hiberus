package com.hiberus.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Tweet {

	private Integer id;

	private String usuario;

	private String texto;

	private String localizacion;

	private boolean validacion = false;

	public Tweet(Integer id, String usuario, String texto, String localizacion, boolean validacion) {
		this.id = id;
		this.usuario = usuario;
		this.texto = texto;
		this.localizacion = localizacion;
		this.validacion = validacion;
	}

	public Tweet(String usuario, String texto, String localizacion) {
		this.usuario = usuario;
		this.texto = texto;
		this.localizacion = localizacion;
	}

	public Tweet() {

	}

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

}
