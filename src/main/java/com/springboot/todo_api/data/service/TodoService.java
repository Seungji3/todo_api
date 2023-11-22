package com.springboot.todo_api.data.service;

import com.springboot.todo_api.data.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {

    TodoResponseDto insertTodo(String title, String content);
    List<TodoResponseDto> getAllTodo();

    TodoResponseDto getTodo(Long number);

    TodoResponseDto changeTodoTitle(Long number, String title) throws Exception;

    void deleteTodo(Long number) throws Exception;
}
