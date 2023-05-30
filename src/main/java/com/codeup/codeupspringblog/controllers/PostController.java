package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostsRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController{
    private final PostsRepository postsDao;
    private final UserRepository userDao;

    public PostController(PostsRepository postsDao, UserRepository userDao){
        this.postsDao = postsDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model){
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showForm(Model model){
        User user = userDao.getUserByUsernameIs("example_user");
        String username = "example_user";
        postsDao.getAllByUser_Username(user.getUsername());
        model.addAttribute("username", "Posted by " + ":" + username);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitForm(@RequestParam(name="title") String title, @RequestParam(name="body") String body){
        Post post = new Post(title, body);
        User user = userDao.getUserByUsernameIs("example_user");
        userDao.save(user);
        postsDao.getAllByUser_Username(user.getUsername());
        postsDao.save(post);
        return "redirect:/posts";
    }

}
