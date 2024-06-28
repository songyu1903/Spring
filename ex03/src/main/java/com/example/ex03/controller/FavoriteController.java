package com.example.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FavoriteController {
    @GetMapping("/favorite")
    public String favorite(){
        return "favorite/input";
    }
    @PostMapping("/favorite")
    public String favorite(@RequestParam("colors") List<String> colors,
                         String food,
                         Model model){
        System.out.println("colors = " + colors + ", food = " + food);
        model.addAttribute("colors", colors);
        model.addAttribute("food", food);

        return "favorite/result";
    }
}
