package com.springboot.todo_api.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "sortNum")
    private Long sortNum;

    @Column(name = "isDone")
    @ColumnDefault("false")
    private boolean isDone;

    @PostPersist
    public void setting(){
        this.sortNum = id;
    }
}
