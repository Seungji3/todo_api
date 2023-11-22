package data.service;

import data.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {
    List<TodoResponseDto> getAllTodo();

    TodoResponseDto getTodo(Long number);

    TodoResponseDto changeTodoTitle(Long number, String title) throws Exception;

    void deleteTodo(Long number) throws Exception;
}
