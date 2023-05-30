package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {
  private final PostRepository postDao;
  private final UserRepository userDao;

  public PostController(PostRepository postDao, UserRepository userDao) {
    this.postDao = postDao;
    this.userDao = userDao;
  }

  @GetMapping("/posts")
  public String allPosts(Model model) {
    List<Post> allPosts = postDao.findAll();
    model.addAttribute("posts", allPosts);
    return "posts/index";
  }

  @GetMapping("posts/{id}")
  public String onePost(@PathVariable long id, Model model) {
    Post post = postDao.findById(id);
    String email = post.getUser().getEmail();
    model.addAttribute("post", post);
    return "posts/show";
  }

  @GetMapping("posts/create")
  public String postsViewCreateForm(Model model) {
    String stylesheet = "@{/css/createPost.css}";
    model.addAttribute("stylesheet", stylesheet);
    return "posts/create";
  }

  @PostMapping("posts/create")
  public String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
    Post post = new Post(title, body);
    User user = userDao.findById(1L);
    post.setTitle(title);
    post.setBody(body);
    post.setUser(user);
    postDao.save(post);
    return "redirect:/posts";
  }
}
