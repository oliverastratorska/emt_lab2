package mk.ukim.finki.emt_lab2.web.rest;


import mk.ukim.finki.emt_lab2.model.Categories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/categories")
public class CategoriesRestController {

    @GetMapping
    private List<Categories> findAll() {
        return Arrays.asList(Categories.values());
    }


}
