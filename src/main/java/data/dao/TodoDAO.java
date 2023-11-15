package data.dao;

import data.entity.Todo;
import data.repository.TodoRepository;

public interface TodoDAO{

    Todo insertTodo(Todo todo);

    Todo updateTitle(Long number, String title) throws Exception;

    Todo selectTodo(Long number);

    void deleteTodo(Long number);


}
