package pl.skwarnel.controllers;

import org.springframework.web.bind.annotation.*;
import pl.skwarnel.dao.CategoryDao;
import pl.skwarnel.entities.Category;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/create/{name}/{content}")
    public String create(@PathVariable String name, @PathVariable String content) {
        Category category = new Category(name, content);
        categoryDao.create(category);
        return category.toString();
    }

    @GetMapping("/list")
    public String displayAllCategories() {
        List<Category> categoryList = categoryDao.findAllCategories();
        return categoryList.toString();
    }
}
