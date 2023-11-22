package com.springboot.todo_api.data.dao.impl;

import com.springboot.todo_api.data.entity.Todo;
import com.springboot.todo_api.data.dao.TodoDAO;
import com.springboot.todo_api.data.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoDAOImpl implements TodoDAO {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoDAOImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo insertTodo(String title, String content) {
        Todo todo = new Todo();
        todo.setId(todo.getId()); //todo 안넣어도 될수있음
        todo.setTitle(title);
        todo.setContent(content);
        todo.setDone(todo.isDone());
        todo.setSortNum(todo.getId());

        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTitle(Long number, String title) throws Exception {
        Optional<Todo> selectedTodo = todoRepository.findById(number);

        Todo updateTodo;
        if (selectedTodo.isPresent()) {
            Todo todo = selectedTodo.get();

            todo.setTitle(title);

            updateTodo = todoRepository.save(todo);
        } else {
            throw new Exception();
        }
        return updateTodo;
    }

    @Override
    public Todo selectTodo(Long number) {
        return todoRepository.getById(number);
    }

    @Override
    public Todo deleteTodo(Long number) throws Exception {
        Optional<Todo> selectTodo = todoRepository.findById(number);
        if (selectTodo.isPresent()) {
            Todo todo = todoRepository.getById(number);
            todoRepository.delete(todo);
        } else {
            throw new Exception();
        }
        return null;
    }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }
}
