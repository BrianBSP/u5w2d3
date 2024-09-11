package brianpelinku.u5w2d3.authors;

/*
 * ------user crud-------
 * 1. Get: /users --> findAll
 * 2. Get: /users/{userId} --> findById
 * 3. Post: /users
 * 4. Put: /users/{userId}
 * 5. Delete: /users/{userId}
 *
 * */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // 1. Get: /users --> findAll
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // 2. Get: /users/{userId} --> findById
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        return authorService.getAuthor(authorId);
    }

    // 3. Post: /users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author bodyAuthor) {
        return authorService.saveAuthor(bodyAuthor);
    }

    // 4. Put: /users/{userId}
    @PutMapping("/{authorId}")
    public Author findAuthorByIdAndUpdate(@PathVariable int authorId, @RequestBody Author authorUpdate) {
        return authorService.getAuthorByIdAndUpdate(authorId, authorUpdate);
    }

    // 5. Delete: /users/{userId}
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAuthorByIdAndDelete(@PathVariable int authorId) {
        authorService.getByIdAndDelete(authorId);
    }


}
