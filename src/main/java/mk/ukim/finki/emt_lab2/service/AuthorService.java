package mk.ukim.finki.emt_lab2.service;

import mk.ukim.finki.emt_lab2.model.Author;
import mk.ukim.finki.emt_lab2.model.Books;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
}
