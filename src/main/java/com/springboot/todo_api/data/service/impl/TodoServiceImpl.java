package com.springboot.todo_api.data.service.impl;

import com.springboot.todo_api.data.dao.TodoDAO;
import com.springboot.todo_api.data.dto.TodoResponseDto;
import com.springboot.todo_api.data.entity.Todo;
import com.springboot.todo_api.data.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoDAO todoDAO;

    @Autowired
    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public TodoResponseDto insertTodo(String title, String content) {
        Todo todo = todoDAO.insertTodo(title,content);

        TodoResponseDto todoResponseDto = new TodoResponseDto();
        todoResponseDto.setId(todo.getId());
        todoResponseDto.setTitle(todo.getTitle());
        todoResponseDto.setContent(todo.getContent());
        todoResponseDto.setDone(todo.isDone());
        todoResponseDto.setSortNum(todo.getSortNum());
        return todoResponseDto;
    }

    @Override
    public List<TodoResponseDto> getAllTodo() {
       return null;
    }

    @Override
    public TodoResponseDto getTodo(Long number) {
        Todo selectedtodo = todoDAO.selectTodo(number);

        return getTodoResponseDto(selectedtodo);
    }

    @Override
    public TodoResponseDto changeTodoTitle(Long number, String title) throws Exception {
        Todo selectedtodo = todoDAO.updateTitle(number, title);

        return getTodoResponseDto(selectedtodo);
    }

    @Override
    public void deleteTodo(Long number) throws Exception {
        todoDAO.deleteTodo(number);
    }

    private TodoResponseDto getTodoResponseDto(Todo selectedtodo) {
        TodoResponseDto todoResponseDto = new TodoResponseDto();
        todoResponseDto.setId(selectedtodo.getId());
        todoResponseDto.setTitle(selectedtodo.getTitle());
        todoResponseDto.setContent(selectedtodo.getContent());
        todoResponseDto.setSortNum(selectedtodo.getSortNum());
        todoResponseDto.setDone(selectedtodo.isDone());
        return todoResponseDto;
    }
}
