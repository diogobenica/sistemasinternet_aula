package br.faccamp.model;

import java.math.BigDecimal;

import javax.persistence.Id;

import com.google.gson.Gson;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class Post {
    @Id
    private Long id;
    private String titulo;
    private String subtitulo;
    private String autor;
	private String conteudo;
    
    public Post(){}
    public Post(String titulo, String subtitulo, String conteudo, String autor) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.conteudo = conteudo;
        this.autor= autor;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
    public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
