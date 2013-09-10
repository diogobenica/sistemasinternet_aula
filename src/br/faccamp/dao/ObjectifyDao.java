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
        System.out.println(post.getTitulo());
    }

    public List<Post> findAll(Class<Post> produto) {
        List<Post> lista = new ArrayList<Post>();
        Objectify ofy = ObjectifyService.begin();
        Query<Post> q = ofy.query(Post.class);
        for (Post post : q) {
            lista.add(post);
        }
        return lista;

    }

    public List<Post> findByName(Class<Post> class1, String queryParam) {
        List<Post> lista = new ArrayList<Post>();
        Objectify ofy = ObjectifyService.begin();
        Query<Post> q = ofy.query(Post.class).filter("nome", queryParam);
        for (Post post : q) {
            lista.add(post);
        }
        return lista;
    }
}
