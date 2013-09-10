package br.faccamp.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.faccamp.model.Post;
import br.faccamp.repository.ProdutoRepositoryObjectify;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class PostsServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");

        consultaObjectify(req, resp);
    }

    private void consultaObjectify(HttpServletRequest req,
            HttpServletResponse resp) throws IOException {
        String q = req.getParameter("q");
        if (q == null) {
            resp.getWriter().println(
                    new Gson().toJson(ProdutoRepositoryObjectify.findAll()));
        } else {
            System.out.println(q);
            resp.getWriter().println(
                    new Gson().toJson(ProdutoRepositoryObjectify.findByName(q)));

        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        String titulo = (req.getParameter("titulo"));
        String conteudo = (req.getParameter("conteudo"));
        Post post = new Post(titulo, conteudo);
        System.out.print(post.getTitulo());
        
        gravaGae(post);
        resp.getWriter().println(new Gson().toJson("ok"));
    }

    private void gravaGae(Post produto) {
        ProdutoRepositoryObjectify.persist(produto);
    }
}
