package com.geto.todo.todo_app.controller;

import com.geto.todo.todo_app.model.Tasks;
import com.geto.todo.todo_app.repository.TodoRepo;
import com.geto.todo.todo_app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    TodoService service;

    @Autowired
    TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping("/")
    public String getTasks(Model model){
        List<Tasks> taskList = service.getAllTasks();
        model.addAttribute("task_list",taskList);
        return "tasks_home";
    }

    @PostMapping("/")
    public String createTask(@RequestParam String title){
        service.createTask(title);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String deleteTask(@PathVariable Long id){
        service.deleteTaskById(id);
        return "redirect:/";                        // redirecting to home page refresh the changes and reflect them
    }

    @GetMapping("{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        service.toggleTaskById(id);
        return "redirect:/";
    }
}
