package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerLecture {
  @GetMapping("/home")
  public String welcome() {
    return "home";
  }

  @GetMapping("/hello/{name}")
  public String sayHelloLecture(@PathVariable String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
  }

  @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
  @ResponseBody
  public String addOneLecture(@PathVariable int number) {
    return number + " plus one is " + (number + 1) + "!";
  }

  @GetMapping("/join")
  public String showJoinForm() {
    return "join";
  }
  @PostMapping("/join")
  public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
    model.addAttribute("cohort", "Welcome to " + cohort + "!");
    return "join";
  }
}