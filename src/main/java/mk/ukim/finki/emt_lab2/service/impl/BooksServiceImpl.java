package mk.ukim.finki.emt_lab2.service.impl;

import mk.ukim.finki.emt_lab2.model.*;
import mk.ukim.finki.emt_lab2.model.dto.BooksDto;
import mk.ukim.finki.emt_lab2.model.exceptions.*;
import mk.ukim.finki.emt_lab2.repository.jpa.AuthorRepository;
import mk.ukim.finki.emt_lab2.repository.jpa.BooksRepository;
import mk.ukim.finki.emt_lab2.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    private final AuthorRepository authorRepository;

    private final BooksRepository booksRepository;



    public BooksServiceImpl(AuthorRepository authorRepository, BooksRepository booksRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;

    }


    @Override
    public List<Books> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public Optional<Books> findById(Long id) {
        return this.booksRepository.findById(id);
    }

    @Override
    public Optional<Books> findByName(String name) {
        return this.booksRepository.findByName(name);
    }

    @Override
    public Optional<Books> save(BooksDto booksDto) {
        Author author = this.authorRepository.findById(booksDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException());

        this.booksRepository.deleteByName(booksDto.getName());

        return Optional.of(this.booksRepository.save(new Books(booksDto.getName(), author,booksDto.getCategories(), booksDto.getAvailableCopies())));
    }



    @Override
    public Optional<Books> edit(Long id, BooksDto booksDto) {
        Books books = this.booksRepository.findById(id).orElseThrow(() -> new BooksNotFoundException());

        books.setName(booksDto.getName());
        books.setAvailableCopies(books.getAvailableCopies());
        books.setCategories(books.getCategories());

        Author author = this.authorRepository.findById(booksDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException());
        books.setAuthor(author);
        return Optional.of(this.booksRepository.save(books));
    }

    @Override
    public void deleteById(Long id) {
        this.booksRepository.deleteById(id);

    }


}
