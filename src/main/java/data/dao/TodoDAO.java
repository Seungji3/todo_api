package data.dao;

import data.entity.Todo;
import data.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public interface TodoDAO{

    Todo insertTodo(String title, String content, boolean isdone);

    Todo updateTitle(Long number, String title) throws Exception;

    Todo selectTodo(Long number);

    void deleteTodo(Long number) throws Exception;

    List<Todo> getAllTodo();
}
