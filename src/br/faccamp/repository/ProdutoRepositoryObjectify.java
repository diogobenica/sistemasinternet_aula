package br.faccamp.repository;


import java.util.ArrayList;
import java.util.List;

import br.faccamp.dao.ObjectifyDao;
import br.faccamp.model.Post;

public class ProdutoRepositoryObjectify {


    public static List<Post> findAll() {
        return ObjectifyDao.getInstance().findAll(Post.class);
    }

    public static void persist(Post post) {
        ObjectifyDao.getInstance().persist(post);
    }

    public static List<Post> findByTitle(String q) {
        return ObjectifyDao.getInstance().findByTitle(Post.class,q);
    }

    public static List<Post> findById(String q) {
        return ObjectifyDao.getInstance().findById(Post.class,q);
    }
}

