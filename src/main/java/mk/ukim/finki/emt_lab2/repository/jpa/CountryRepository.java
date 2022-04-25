package mk.ukim.finki.emt_lab2.repository.jpa;

import mk.ukim.finki.emt_lab2.model.Author;
import mk.ukim.finki.emt_lab2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository  extends JpaRepository<Country, Long> {
}
