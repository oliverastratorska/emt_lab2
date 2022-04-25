package mk.ukim.finki.emt_lab2.service;


import mk.ukim.finki.emt_lab2.model.Books;
import mk.ukim.finki.emt_lab2.model.dto.BooksDto;

import java.util.List;
import java.util.Optional;

public interface BooksService {
    List<Books> findAll();

    Optional<Books> findById(Long id);

    Optional<Books> findByName(String name);

    Optional<Books> save(BooksDto booksDto);

    Optional<Books> edit(Long id, BooksDto booksDto);

    void deleteById(Long id);

}
