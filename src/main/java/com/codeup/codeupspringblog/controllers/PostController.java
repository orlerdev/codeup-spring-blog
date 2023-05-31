package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostsRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
public class PostController{
    public User randomUser(UserRepository usersDao){
        List<User> allUsers = usersDao.findAll();
        int randomInt = new Random().nextInt(allUsers.size());
        return allUsers.get(randomInt);
    }

    private final PostsRepository postDao;
    private final UserRepository userDao;

    public PostController(PostsRepository postsDao, UserRepository userDao){
        this.postDao = postsDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        User user = randomUser(userDao);
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("username", "Post author: " + user.getUsername());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitForm(@RequestParam(name="title") String title, @RequestParam(name="body") String body){
        User user = randomUser(userDao);
        Post post = new Post(title, body, user);
        postDao.save(post);
        return "redirect:/user_posts";
    }

}
