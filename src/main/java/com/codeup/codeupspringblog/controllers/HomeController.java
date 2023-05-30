package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class HomeController {
  @GetMapping("/")
  public String welcome(Model model) {
    return "home";
  }
}

