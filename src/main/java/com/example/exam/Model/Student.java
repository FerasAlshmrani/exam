package com.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "id should not be empty")
    private String id;

    @NotEmpty(message = "name should not be empty")
    private String name;

    @NotNull(message = "age should not be empty")
    private Integer age;

    @NotEmpty(message = "major should not be empty")
    private String major;



}
