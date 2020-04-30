package com.biblio.domain;

public class Anime {
	
	Integer id;
	String nomeAnime;
	String sinopse;
	String categoria;
	
	
	public Anime() {
		super();
	}

	public Anime(Integer id, String nomeAnime, String sinopse, String categoria) {
		super();
		this.id = id;
		this.nomeAnime = nomeAnime;
		this.sinopse = sinopse;
		this.categoria = categoria;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeAnime() {
		return nomeAnime;
	}
	public void setNomeAnime(String nomeAnime) {
		this.nomeAnime = nomeAnime;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinpse) {
		this.sinopse = sinpse;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
