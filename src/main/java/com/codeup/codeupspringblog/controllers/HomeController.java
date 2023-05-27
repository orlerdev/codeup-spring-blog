package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HomeController {
  @GetMapping("/")
  @ResponseBody
  public String welcome() {
    return "This is the landing page!";
  }
}

