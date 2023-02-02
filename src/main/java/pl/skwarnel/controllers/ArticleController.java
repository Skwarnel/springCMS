package pl.skwarnel.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.skwarnel.dao.ArticleDao;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleDao articleDao;

    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}
