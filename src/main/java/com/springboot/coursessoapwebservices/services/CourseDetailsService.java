package com.springboot.coursessoapwebservices.services;

import com.springboot.coursessoapwebservices.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CourseDetailsService {
    public enum StatusBean{
        SUCCESS,FALIUR
    }
    List<Course> courses;
    public CourseDetailsService(){
        courses = new ArrayList<>();
        courses.add(Course.builder().id(1).name("amr").description("hello there").build());
        courses.add(Course.builder().id(2).name("amr").description("hello there").build());
        courses.add(Course.builder().id(3).name("amr").description("hello there").build());
        courses.add(Course.builder().id(4).name("amr").description("hello there").build());
        courses.add(Course.builder().id(5).name("amr").description("hello there").build());
    }
    public List<Course> findAll(){
        return this.courses;
    }

    public Course findById(int id ){
        Optional<Course> courseOptional = this.courses.stream().filter(course -> course.getId()== id).findFirst();
        if(courseOptional.isPresent()){
            return courseOptional.get();
        }else {
            return null;
        }
    }

    public StatusBean deleteCourse(int id){
        Iterator iterator = this.courses.iterator();
        while(iterator.hasNext()){
            Course course1 =(Course) iterator.next();
            if(course1.getId() == id){
                iterator.remove();
                return StatusBean.SUCCESS;
            }
        }
        return StatusBean.FALIUR;
    }

}
