package pl.skwarnel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skwarnel.dao.ArticleDao;
import pl.skwarnel.dao.AuthorDao;
import pl.skwarnel.entities.Article;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/list")
    public String displayAllArticles() {
        List<Article> resultList = articleDao.findAllArticles();
        return resultList.toString();
    }

    @RequestMapping("/create")
    public String createArticle() {
        Article article = new Article();
        article.setAuthor(authorDao.getAuthor(1L));
        article.setContent("JavaContent");
        articleDao.save(article);
//        article.setCategories();
        return articleDao.findAllArticles().toString();
    }
}
