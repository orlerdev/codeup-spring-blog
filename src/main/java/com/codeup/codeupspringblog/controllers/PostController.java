package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
  @GetMapping("/posts")
  @ResponseBody
  public String posts() {
    return "Posts index page";
  }
    @GetMapping("/posts/{id}")
  @ResponseBody
  public String postsId(@PathVariable int id) {
    return "Posts index page number " + ": " + id + ".";
  }
    @GetMapping("/posts/create")
  @ResponseBody
  public String postsViewCreateForm() {
    return "Posts index page";
  }
    @PostMapping("/posts/create")
  @ResponseBody
  public String postsCreate() {
    return "Create new posts.";
  }
}
