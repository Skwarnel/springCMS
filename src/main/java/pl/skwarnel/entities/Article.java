package pl.skwarnel.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 200)
    String title;
    @OneToOne
    Author author;
    @OneToMany
    List<Category> categories = new ArrayList<>();
    String content;
    @CreationTimestamp
    LocalDateTime createdOn;
    @UpdateTimestamp
    LocalDateTime updatedOn;

}
