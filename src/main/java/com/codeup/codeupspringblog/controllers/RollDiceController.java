package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import static com.codeup.codeupspringblog.utils.RandomNumRange.randomNum;

@Controller
public class RollDiceController {
  @GetMapping("/roll-dice")
  public String rollDice() {
    return "roll-dice";
  }

  @GetMapping("/roll-dice/{n}")
  public String rollDiceNums(@PathVariable int n, String result, Model model) {
  int randomNumber = randomNum(1, 6);
    if (n <= 0 || n > 6) {
      model.addAttribute("n", "You selected " + n + "." + " You must select a number between 1 and 6.");
    } else {
      model.addAttribute("n", "You selected " + n + ".");
    }

    model.addAttribute("randomNumber", "The correct number was " + randomNumber + ".");

    if (n == randomNumber) {
      model.addAttribute("result", "You guessed correctly!");
    } else {
      model.addAttribute("result", "You did not guess the number.");
    }

    return "roll-dice";
  }

}
