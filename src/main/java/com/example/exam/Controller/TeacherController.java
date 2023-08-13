package com.example.exam.Controller;


import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Teacher;
import com.example.exam.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ArrayList<Teacher> getTeacher(){
        ArrayList<Teacher> teachers = teacherService.getTeachers();
        return teachers;
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeachers(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@RequestBody Teacher teacher,@PathVariable String id,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        int found = teacherService.updateTeachers(teacher,id);
        if(found == -1){
            return ResponseEntity.status(400).body(new ApiResponse("Wrong id"));
        }
        return  ResponseEntity.status(200).body(new ApiResponse("Teacher Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){

        int found = teacherService.removeTeacher(id);
        if(found == -1){
            return ResponseEntity.status(400).body(new ApiResponse("Wrong id"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Deleted"));
    }

    @GetMapping("/search-teacher/{id}")
    public ResponseEntity searchTeacher(@PathVariable String id){

        Teacher found = teacherService.searchTeacher(id);
        if(found.getName().equals("")){
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(found);
    }



}
