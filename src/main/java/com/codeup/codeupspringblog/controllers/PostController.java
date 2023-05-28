package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
  @GetMapping("/posts")
  @ResponseBody
  public String posts() {
    return "posts";
  }
    @GetMapping("/posts/show")
  @ResponseBody
  public String showPosts() {
    return "posts";
  }
    @GetMapping("/posts/create")
  @ResponseBody
  public String postsViewCreateForm() {
    return "posts";
  }
    @PostMapping("/posts/create")
  @ResponseBody
  public String postsCreate() {
    return "posts";
  }
}
