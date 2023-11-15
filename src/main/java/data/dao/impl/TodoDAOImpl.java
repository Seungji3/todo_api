package data.dao.impl;

import data.dao.TodoDAO;
import data.entity.Todo;
import data.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TodoDAOImpl implements TodoDAO {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoDAOImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo insertTodo(Todo todo) {
        Todo insertTodo = todoRepository.save(todo);
        return insertTodo;
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
        Todo todo = todoRepository.getById(number);
        return todo;
    }

    @Override
    public void deleteTodo(Long number) {
        Todo todo = todoRepository.getById(number);
        todoRepository.delete(todo);
    }
}
