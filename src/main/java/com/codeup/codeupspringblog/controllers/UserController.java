package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.dao.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
  private final UserRepository userDao;

  public UserController(UserRepository userDao) {
    this.userDao = userDao;
  }

}
