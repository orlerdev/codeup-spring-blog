package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeController {
  @GetMapping("/coffee")
  public String coffeePage() {
    return "coffee";
  }
}
