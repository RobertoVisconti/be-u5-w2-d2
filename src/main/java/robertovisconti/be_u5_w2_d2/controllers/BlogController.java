package robertovisconti.be_u5_w2_d2.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import robertovisconti.be_u5_w2_d2.entities.Blog;
import robertovisconti.be_u5_w2_d2.payloads.BlogPayload;
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

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody BlogPayload body) {
        return this.blogService.saveBlog(body);
    }

    // GET BY ID
    @GetMapping("/{blogId}")
    public Blog findById(@PathVariable long blogId) {
        return this.blogService.findById(blogId);
    }

    // PUT
    @PutMapping("/{blogId}")
    public Blog findByIdAndUpdate(@PathVariable long blogId, @RequestBody BlogPayload body) {
        return this.blogService.findByIdAndUpdate(blogId, body);
    }

    // DELETE
    @DeleteMapping("/{blodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long blogId) {
        this.blogService.findByIdAndDelete(blogId);
    }
}
