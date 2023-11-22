package com.springboot.todo_api.data.controller;

import com.springboot.todo_api.data.dto.TodoResponseDto;
import com.springboot.todo_api.data.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Todo API", description = "Todo Controller")
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(summary = "Todo 입력")
    @PostMapping("insert")
//    @Parameter(name = "title")
//    @Parameter(name = "content")
    public ResponseEntity<TodoResponseDto> insertTodo(@RequestParam String title, @RequestParam(required = false) String content) {
        TodoResponseDto todoResponseDto = todoService.insertTodo(title,content);
        return ResponseEntity.status(HttpStatus.OK).body(todoResponseDto);
    }

    @Operation(summary = "Title 변경")
    @PatchMapping("/title")
    public ResponseEntity<TodoResponseDto> updateTitle(@RequestParam Long number, @RequestParam String title) throws Exception {
        TodoResponseDto todoResponseDto = todoService.changeTodoTitle(number,title);
        return ResponseEntity.status(HttpStatus.OK).body(todoResponseDto);
    }

    @Operation(summary = "id로 정보 확인")
    @PostMapping("/num")
    public ResponseEntity<TodoResponseDto> selectTodo(@RequestParam Long number){
        TodoResponseDto todoResponseDto = todoService.getTodo(number);
        return ResponseEntity.status(HttpStatus.OK).body(todoResponseDto);
    }

    @Operation(summary = "id로 정보 삭제")
    @DeleteMapping("/num")
    public void deleteTodo(@RequestParam Long number) throws Exception {
        todoService.deleteTodo(number);
    }


}
