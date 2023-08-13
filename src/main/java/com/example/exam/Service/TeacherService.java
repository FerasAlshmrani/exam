package com.example.exam.Service;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher>teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public void addTeachers(Teacher teacher){
        teachers.add(teacher);
    }

    public int updateTeachers(Teacher teacher,String id){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return 1;
            }
        }
        return -1;
    }
    public int removeTeacher(String id){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return 1;
            }
        }
        return -1;
    }
    public Teacher searchTeacher(String id){
        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId().equals(id)){
                return teachers.get(i);
            }
        }
        return new Teacher("","",0);
    }
}
