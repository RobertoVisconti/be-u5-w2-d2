package robertovisconti.be_u5_w2_d2.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import robertovisconti.be_u5_w2_d2.entities.Author;
import robertovisconti.be_u5_w2_d2.payloads.AuthorPayload;
import robertovisconti.be_u5_w2_d2.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //GET
    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody AuthorPayload body) {
        return this.authorService.saveAuthor(body);
    }

    // GET BY ID
    @GetMapping("/{authorId}")
    public Author findById(@PathVariable long authorId) {
        return this.authorService.findById(authorId);
    }

}
