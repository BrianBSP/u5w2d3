package brianpelinku.u5w2d3.blogs;

import brianpelinku.u5w2d3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogsList = new ArrayList<>();

    // 1. Get: /blogs --> findAll
    public List<Blog> getAllBlogs() {
        return this.blogsList;
    }

    // 2. Get: /blogs/{blogId} --> findById
    public Blog getBlog(int blogId) {
        return this.blogsList.stream().filter(blog -> blog.getId() == blogId).findFirst().orElseThrow(() -> new NotFoundException(blogId));
    }

    // 3. Post: /blogs
    public Blog saveBlog(Blog blog) {
        Random random = new Random();
//        blog.setId(random.nextInt(1, 100));
        blog.setCover("https://picsum.photos/200/300");
        this.blogsList.add(blog);
        return blog;
    }

    // 4. Put: /blogs/{blogId}
    public Blog getBlogByIdAndUpdate(int blogId, Blog bodyBlog) {
        Blog found = null;

        for (Blog blog : this.blogsList) {
            if (blog.getId() == blogId) {
                found = blog;
                found.setCategoria(bodyBlog.getCategoria());
                found.setTitolo(bodyBlog.getTitolo());
                found.setCover(bodyBlog.getCover());
                found.setContenuto(bodyBlog.getContenuto());
                found.setTempoDiLettura(bodyBlog.getTempoDiLettura());
            }
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    // 5. Delete: /blogs/{blogId}
    public void getBlogByIdAndDelete(int blogId) {
        Blog found = null;

        for (Blog blog : this.blogsList) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(blogId);
        this.blogsList.remove(found);
    }
}
