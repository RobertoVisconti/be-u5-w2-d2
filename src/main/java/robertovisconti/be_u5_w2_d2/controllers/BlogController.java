package robertovisconti.be_u5_w2_d2.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import robertovisconti.be_u5_w2_d2.entities.Blog;
import robertovisconti.be_u5_w2_d2.services.BlogService;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;

    }

    // GET
    @GetMapping
    public List<Blog> findAll() {
        return this.blogService.findAll();
    }
}
