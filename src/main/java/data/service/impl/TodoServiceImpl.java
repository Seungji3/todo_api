package data.service.impl;

import data.dao.TodoDAO;
import data.dto.TodoResponseDto;
import data.entity.Todo;
import data.service.TodoService;
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
    public List<TodoResponseDto> getAllTodo() {
        List<Todo> todo = todoDAO.getAllTodo();
        return null;
    }

    @Override
    public TodoResponseDto getTodo(Long number) {
        Todo selectedtodo = todoDAO.selectTodo(number);

        TodoResponseDto todoResponseDto = new TodoResponseDto();
        todoResponseDto.setId(selectedtodo.getId());
        todoResponseDto.setTitle(selectedtodo.getTitle());
        todoResponseDto.setContent(selectedtodo.getContent());
        todoResponseDto.setSortNum(selectedtodo.getSortNum());
        todoResponseDto.setDone(selectedtodo.isDone());

        return todoResponseDto;
    }

    @Override
    public TodoResponseDto changeTodoTitle(Long number, String title) throws Exception {
        Todo selectedtodo = todoDAO.updateTitle(number, title);

        TodoResponseDto todoResponseDto = new TodoResponseDto();
        todoResponseDto.setId(selectedtodo.getId());
        todoResponseDto.setTitle(selectedtodo.getTitle());
        todoResponseDto.setContent(selectedtodo.getContent());
        todoResponseDto.setSortNum(selectedtodo.getSortNum());
        todoResponseDto.setDone(selectedtodo.isDone());

        return todoResponseDto;
    }

    @Override
    public void deleteTodo(Long number) throws Exception {
        todoDAO.deleteTodo(number);
    }
}
