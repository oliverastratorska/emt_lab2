package mk.ukim.finki.emt_lab2.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Books {
    public Long getId() {
        return id;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    @Enumerated(value = EnumType.STRING)
    private Categories categories;

    private Integer availableCopies;

    public Books(String name, Author author,Categories categories, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.categories = categories;
    }

    public Books() {

    }
}
