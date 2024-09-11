package brianpelinku.u5w2d3.authors;

import brianpelinku.u5w2d3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authorsList = new ArrayList<>();

    // 1. Get: /users --> findAll
    public List<Author> getAllAuthors() {
        return this.authorsList;
    }

    // 2. Get: /users/{userId} --> findById
    public Author getAuthor(int userId) {
        Author found = null;
        for (Author user : this.authorsList) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    // 3. Post: /users
    public Author saveAuthor(Author bodyUser) {
        Random random = new Random();
//        bodyUser.setId(random.nextInt(1, 100));
        bodyUser.setAvatar("https://ui-avatars.com/api/?name=" + bodyUser.getNome() + "+" + bodyUser.getCognome());
        this.authorsList.add(bodyUser);
        return bodyUser;
    }

    // 4. Put: /users/{userId}
    public Author getAuthorByIdAndUpdate(int userId, Author updateUser) {
        Author found = null;
        for (Author user : this.authorsList) {
            if (user.getId() == userId) {
                found = user;
                found.setNome(updateUser.getNome());
                found.setCognome(updateUser.getCognome());
                found.setEmail(updateUser.getEmail());
            }
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    // 5. Delete: /users/{userId}
    public void getByIdAndDelete(int userId) {
        Author found = null;
        for (Author user : this.authorsList) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        this.authorsList.remove(found);
    }

}
