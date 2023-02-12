package pl.skwarnel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skwarnel.dao.AuthorDao;
import pl.skwarnel.entities.Author;

import javax.persistence.TypedQuery;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String displayAllAuthors() {
        List<Author> authorList = authorDao.findAllAuthors();
        return authorList.toString();
    }

    @GetMapping("/listArticles")
    public String displayAllAuthorsWithBooks() {
        List<Author> authorList = authorDao.findAllAuthorsWithArticles();
        return authorList.toString();
    }
}
