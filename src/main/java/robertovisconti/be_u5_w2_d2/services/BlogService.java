package robertovisconti.be_u5_w2_d2.services;


import org.springframework.stereotype.Service;
import robertovisconti.be_u5_w2_d2.entities.Blog;
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

}
