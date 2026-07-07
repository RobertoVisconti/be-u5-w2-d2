package robertovisconti.be_u5_w2_d2.services;


import org.springframework.stereotype.Service;
import robertovisconti.be_u5_w2_d2.entities.Author;
import robertovisconti.be_u5_w2_d2.exceptions.NotFoundExceptions;
import robertovisconti.be_u5_w2_d2.payloads.AuthorPayload;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private List<Author> authorDB = new ArrayList<>();


    // ritorno gli autori
    public List<Author> findAll() {
        return this.authorDB;
    }

    // salvo gli autori
    public Author saveAuthor(AuthorPayload body) {
        Author newAuthor = new Author(body.getName(), body.getSurname(), body.getEmail(), body.getDataDiNascita());
        this.authorDB.add(newAuthor);
        return newAuthor;
    }

    // ricerca tramite id
    public Author findById(long authorId) {
        Author found = null;

        for (Author author : this.authorDB) {
            if (author.getId() == authorId) found = author;
        }

        if (found == null) throw new NotFoundExceptions(authorId);

        return found;
    }

    // ricerca tramite id e update
    public Author findByIdAndUpdate(long authorId, AuthorPayload body) {
        Author found = this.findById(authorId);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());
        return found;
    }
}
