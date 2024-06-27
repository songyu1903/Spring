package com.example.ex03.controller;

import com.example.ex03.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @GetMapping("/register")
    public String TodoRegister(){
        return "todo/register";
    }
    @PostMapping("/register")
    public String TodoRegister(TodoDTO todoDTO, Model model){
        System.out.println("todoDTO = " + todoDTO);

        model.addAttribute("todo", todoDTO);

        return "todo/result";
    }
}
