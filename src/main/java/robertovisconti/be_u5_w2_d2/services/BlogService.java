package robertovisconti.be_u5_w2_d2.services;


import org.springframework.stereotype.Service;
import robertovisconti.be_u5_w2_d2.entities.Blog;
import robertovisconti.be_u5_w2_d2.exceptions.NotFoundExceptions;
import robertovisconti.be_u5_w2_d2.payloads.BlogPayload;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    private List<Blog> blogDB = new ArrayList<>();


    // ritorno i blog
    public List<Blog> findAll() {
        return this.blogDB;
    }

    // salvo i blog
    public Blog saveBlog(BlogPayload body) {
        Blog newBlog = new Blog(body.getCategoria(), body.getTitolo(), body.getContenuto(), body.getTempoDiLettura());
        this.blogDB.add(newBlog);
        return newBlog;
    }


    // ricerca tramite id
    public Blog findById(long blogId) {
        Blog found = null;

        for (Blog blog : this.blogDB) {
            if (blog.getId() == blogId) found = blog;
        }

        if (found == null) throw new NotFoundExceptions(blogId);

        return found;
    }

    // ricerca tramite id e update
    public Blog findByIdAndUpdate(long blogId, BlogPayload body) {
        Blog found = this.findById(blogId);
        found.setTitolo(body.getTitolo());
        found.setCategoria(body.getCategoria());
        found.setContenuto(body.getContenuto());
        found.setTempoDiLettura(body.getTempoDiLettura());

        return found;
    }

    // ricerca tramite id e delete
    public Blog findByIdAndDelete(long blogId) {
        Blog found = this.findById(blogId);
        this.blogDB.remove(found);
        return found;
    }
}
