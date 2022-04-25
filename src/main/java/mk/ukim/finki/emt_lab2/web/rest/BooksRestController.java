package mk.ukim.finki.emt_lab2.web.rest;


import mk.ukim.finki.emt_lab2.model.Books;
import mk.ukim.finki.emt_lab2.model.dto.BooksDto;
import mk.ukim.finki.emt_lab2.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BooksRestController {

    private final BooksService booksService;

    public BooksRestController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    private List<Books> findAll() {
        return this.booksService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> findById(@PathVariable Long id) {
        return this.booksService.findById(id)
                .map(books -> ResponseEntity.ok().body(books))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Books> save(@RequestBody BooksDto booksDto) {
        return this.booksService.save(booksDto)
                .map(books -> ResponseEntity.ok().body(books))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Books> save(@PathVariable Long id, @RequestBody BooksDto booksDto) {
        return this.booksService.edit(id, booksDto)
                .map(books -> ResponseEntity.ok().body(books))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.booksService.deleteById(id);
        if (this.booksService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
