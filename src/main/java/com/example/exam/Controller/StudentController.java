package com.example.exam.Controller;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Student;
import com.example.exam.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ArrayList<Student> getStudent(){
        ArrayList<Student> students = studentService.getStudents();
        return students;
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@RequestBody Student student,@PathVariable String id,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        int found = studentService.updateStudent(student,id);
        if(found == -1){
            return ResponseEntity.status(400).body(new ApiResponse("Wrong id"));
        }
        return  ResponseEntity.status(200).body(new ApiResponse("user Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){

        int found = studentService.removeStudent(id);
        if(found == -1){
            return ResponseEntity.status(400).body(new ApiResponse("Wrong id"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("User Deleted"));
    }

    @GetMapping("/search-student/{name}")
    public ResponseEntity searchTeacher(@PathVariable String name){

        Student found = studentService.searchStudent(name);
        if(found.getName().equals("")){
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(found);
    }



}
