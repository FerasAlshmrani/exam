package com.example.exam.Service;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public int updateStudent(Student student,String id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)){
                students.set(i,student);
                return 1;
            }
        }
        return -1;
    }
    public int removeStudent(String id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)){
                students.remove(i);
                return 1;
            }
        }
        return -1;
    }

    public Student searchStudent(String name){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name)){
                //return new ApiResponse(""+students.get(i));
                return students.get(i);
            }
        }
        //return new ApiResponse("not found");
        return new Student("","",0,"");

    }
}
