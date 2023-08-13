package com.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "id should not be empty")
    private String id;

    @NotEmpty(message = "name should not be empty")
    private String name;

    @NotNull(message = "salary should not be empty")
    private Integer salary;
}
