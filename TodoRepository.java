package com.todo.todolist.repository;

import com.todo.todolist.entity.Todoentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todoentity,Long> {
}
