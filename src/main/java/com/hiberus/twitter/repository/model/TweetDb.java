package com.hiberus.twitter.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
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
