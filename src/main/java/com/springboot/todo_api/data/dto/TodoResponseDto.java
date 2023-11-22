package com.springboot.todo_api.data.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long sortNum;
    private boolean isDone;
}
