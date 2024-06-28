package com.example.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FavoriteController {
    @GetMapping("/favorite")
    public String favorite(){
        return "favorite/input";
    }
    @PostMapping("favorite")
    public void favorite(@RequestParam("colors") List<String> colors){
        System.out.println("colors = " + colors);
    }
}
