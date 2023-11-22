package com.springboot.todo_api.data.dao;

import com.springboot.todo_api.data.entity.Todo;

import java.util.List;

public interface TodoDAO{

    Todo insertTodo(String title, String content);

    Todo updateTitle(Long number, String title) throws Exception;

    Todo selectTodo(Long number);

    Todo deleteTodo(Long number) throws Exception;

    List<Todo> getAllTodo();
}
