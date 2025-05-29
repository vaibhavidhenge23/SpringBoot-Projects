package com.todo.todolist.controller;


import com.todo.todolist.entity.Todoentity;
import com.todo.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;



    @GetMapping("/home")
    public String showHomepage(Model model){
        model.addAttribute("todos",todoRepository.findAll());
        todoRepository.findAll();
return "index";
    }
    @PostMapping("/add")
    public String add(@RequestParam String title){
        Todoentity newTodo= Todoentity.builder()
                .title(title)
                .completed(false)
                .build();
        todoRepository.save(newTodo);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id){
      Todoentity existingTodo=  todoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("todo not found"+id));
   existingTodo.setCompleted(true);
   todoRepository.save(existingTodo);
   return "redirect:/";
    }
    @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id){
        Todoentity existingTodo= todoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("todo not found"+id));
todoRepository.delete(existingTodo);
return "redirect:/";


    }
}
