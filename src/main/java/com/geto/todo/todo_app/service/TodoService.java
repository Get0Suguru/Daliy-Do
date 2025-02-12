package com.geto.todo.todo_app.service;

import com.geto.todo.todo_app.model.Tasks;
import com.geto.todo.todo_app.repository.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    TodoRepo repo;
    TodoService(TodoRepo repo){
        this.repo = repo;
    }

    public List<Tasks> getAllTasks() {
        return repo.findAll();
    }

    public void createTask(String title) {
        Tasks task = new Tasks();
        task.setTitle(title);
        task.setStatus(false);
        repo.save(task);
    }

    public void deleteTaskById(Long id) {
        repo.deleteById(id);
    }

    public void toggleTaskById(Long id) {
        Tasks tempTask = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task id"));
        tempTask.setStatus(!tempTask.isStatus());
        repo.save(tempTask);
    }


}
