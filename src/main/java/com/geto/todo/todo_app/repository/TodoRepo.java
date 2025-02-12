package com.geto.todo.todo_app.repository;

import com.geto.todo.todo_app.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Tasks, Long> {

}
