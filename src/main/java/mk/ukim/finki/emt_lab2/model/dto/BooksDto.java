package mk.ukim.finki.emt_lab2.model.dto;

import lombok.Data;
import mk.ukim.finki.emt_lab2.model.Author;
import mk.ukim.finki.emt_lab2.model.Categories;

import javax.persistence.ManyToOne;
@Data
public class BooksDto {

    private String name;

    private Long author;

    private Categories categories;

    private Integer availableCopies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public BooksDto(String name, Long author,Categories categories, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.categories = categories;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
