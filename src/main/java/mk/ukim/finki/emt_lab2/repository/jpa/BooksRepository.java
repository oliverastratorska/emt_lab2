package mk.ukim.finki.emt_lab2.repository.jpa;

import mk.ukim.finki.emt_lab2.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Optional<Books> findByName(String name);
    void deleteByName(String name);
}
