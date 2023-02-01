INSERT INTO authors (firstName, lastName) VALUES ('author_name', 'author_lastName');
INSERT INTO articles (content, createdOn, title, updatedOn, author_id)
VALUES ('content', '2023-02-01', 'title', '2023-02-01', 1);
INSERT INTO categories (description, name) VALUES ('description_value', 'category_name');
# USE springHomework;
SELECT * FROM authors;
SELECT * FROM articles;
SELECT * FROM categories;

# DROP DATABASE springHomework;

# CREATE DATABASE springHomework;