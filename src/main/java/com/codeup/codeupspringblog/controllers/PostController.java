package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
  private final PostRepository postDao;

  public PostController(PostRepository postDao) {
    this.postDao = postDao;
  }

  @GetMapping("/posts")
  public String posts(Model model) {
    model.addAttribute("posts", postDao.findAll());
    return "posts/index";
  }

  @GetMapping("/show")
  public String showPosts() {
    return "posts/show";
  }

  @GetMapping("/create")
  public String postsViewCreateForm() {
    return "posts/create";
  }

  @PostMapping("/create")
  public String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
    Post post = new Post(title, body);
    postDao.save(post);
    return "redirect:/posts";
  }
}
