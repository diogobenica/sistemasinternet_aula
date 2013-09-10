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
    private String conteudo;
    
    public Post(){}
    public Post(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
	public String getTitulo() {
		return titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
}
