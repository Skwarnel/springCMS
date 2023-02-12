INSERT INTO authors (firstName, lastName) VALUES ('author_name', 'author_lastName');
INSERT INTO articles (content, createdOn, title, updatedOn, author_id)
VALUES ('content', '2023-02-01', 'title', '2023-02-01', 1);
INSERT INTO categories (description, name) VALUES ('description_value', 'category_name');
# USE springHomework;
SELECT * FROM authors;
SELECT * FROM articles;
SELECT * FROM categories;

# DROP DATABASE springHomework;

CREATE DATABASE springHomework CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE springHomework;
SELECT * FROM articles;
SELECT * FROM authors;
SELECT * FROM categories;

INSERT INTO articles (content, title, author_id) VALUES ('myContent_1', 'myTitle_1', 3),
('myContent_2', 'myTitle_2', 3),
('myContent_3', 'myTitle_3', 3),
('myContent_1', 'myTitle_1', 1),
('myContent_2', 'myTitle_2', 1),
('myContent_3', 'myTitle_3', 1),
('myContent_1', 'myTitle_1', 2),
('myContent_2', 'myTitle_2', 2),
('myContent_3', 'myTitle_3', 2);

INSERT INTO authors (firstName, lastName) VALUES ('author_1', 'author_1'), ('author_2', 'author_2'), ('author_3', 'author_3');

INSERT INTO categories (description, name) VALUES ('Categorie_Desc_1', 'Category_name_1'),
                                                  ('Categorie_Desc_2', 'Category_name_2'),
                                                  ('Categorie_Desc_3', 'Category_name_3');
SELECT * FROM authors LEFT JOIN articles ON authors.id = articles.author_id;