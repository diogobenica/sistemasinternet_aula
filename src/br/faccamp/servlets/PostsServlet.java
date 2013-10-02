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
        resp.setContentType("application/json; charset=utf-8");

        consultaObjectify(req, resp);
    }

    private void consultaObjectify(HttpServletRequest req,
            HttpServletResponse resp) throws IOException {
        String q = req.getParameter("q");
        String id = req.getParameter("id");
        String callback = req.getParameter("callback");
        
        if (q != null) {
        	resp.getWriter().println(callback+"("+
                    new Gson().toJson(ProdutoRepositoryObjectify.findByTitle(q))+")");
        } else if(id != null) {
            resp.getWriter().println(callback+"("+
                    new Gson().toJson(ProdutoRepositoryObjectify.findById(id))+")");

        } else {
        	resp.getWriter().println(callback+"("+
                    new Gson().toJson(ProdutoRepositoryObjectify.findAll())+")");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("application/json");
        String titulo = (req.getParameter("titulo"));
        String subtitulo = (req.getParameter("subtitulo"));
        String autor = (req.getParameter("autor"));
        String conteudo = (req.getParameter("conteudo"));
        Post post = new Post(titulo, subtitulo, conteudo, autor);
        System.out.print(post.getTitulo());
        
        gravaGae(post);
        resp.getWriter().println(new Gson().toJson("ok"));
    }

    private void gravaGae(Post produto) {
        ProdutoRepositoryObjectify.persist(produto);
    }
}
