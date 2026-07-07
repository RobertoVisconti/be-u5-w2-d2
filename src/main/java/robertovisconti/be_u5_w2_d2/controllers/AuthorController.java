package robertovisconti.be_u5_w2_d2.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import robertovisconti.be_u5_w2_d2.entities.Author;
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

}
