package com.springboot.coursessoapwebservices.services;

import com.springboot.courses.CourseDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseDetailsService {
    List<CourseDetails> courses;
    public CourseDetailsService(){
        courses = new ArrayList<>();
        courses.add(CourseDetails.builder().id(1).name("amr").description("hello there").build());
        courses.add(CourseDetails.builder().id(2).name("amr").description("hello there").build());
        courses.add(CourseDetails.builder().id(3).name("amr").description("hello there").build());
        courses.add(CourseDetails.builder().id(4).name("amr").description("hello there").build());
        courses.add(CourseDetails.builder().id(5).name("amr").description("hello there").build());
    }
    public List<CourseDetails> findAll(){
        return this.courses;
    }

    public CourseDetails findById(int id ){
        Optional<CourseDetails> courseDetails = this.courses.stream().filter(course -> course.getId()== id).findFirst();
        if(courseDetails.isPresent()){
            return courseDetails.get();
        }else {
            return null;
        }
    }
}
