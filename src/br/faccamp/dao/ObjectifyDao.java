package br.faccamp.dao;

import java.util.ArrayList;
import java.util.List;

import br.faccamp.model.Post;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class ObjectifyDao {

    private static ObjectifyDao instance;

    private ObjectifyDao() {
        ObjectifyService.register(Post.class);
    }

    public static ObjectifyDao getInstance() {
        if (instance == null)
            instance = new ObjectifyDao();
        return instance;
    }

    public void persist(Post post) {
        Objectify ofy = ObjectifyService.begin();
        ofy.put(post);
        System.out.println("Gravou");
        System.out.println(post.getAutor());
    }

    public List<Post> findAll(Class<Post> produto) {
        List<Post> lista = new ArrayList<Post>();
        Objectify ofy = ObjectifyService.begin();
        Query<Post> q = ofy.query(Post.class);
        for (Post post : q) {
        	post.setAutor(null);
        	post.setConteudo(null);
            lista.add(post);
        }
        return lista;

    }

    public List<Post> findByTitle(Class<Post> class1, String queryParam) {
        List<Post> lista = new ArrayList<Post>();
        Objectify ofy = ObjectifyService.begin();
        Query<Post> q = ofy.query(Post.class);
        for (Post post : q) {
        	if(post.getTitulo().contains(queryParam)){
        		lista.add(post);
        	}
        }
        return lista;
    }
    
    public List<Post> findById(Class<Post> class1, String queryParam) {
        List<Post> lista = new ArrayList<Post>();
        Objectify ofy = ObjectifyService.begin();
        Query<Post> q = ofy.query(Post.class);
        for (Post post : q) {
        	if(post.getId() == Long.parseLong(queryParam)){
        		lista.add(post);
        	}
        }
        return lista;
    }
}
