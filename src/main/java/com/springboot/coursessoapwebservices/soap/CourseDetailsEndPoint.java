package com.springboot.coursessoapwebservices.soap;

import com.springboot.courses.*;
import com.springboot.coursessoapwebservices.models.Course;
import com.springboot.coursessoapwebservices.services.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndPoint {
    @Autowired
    private CourseDetailsService courseDetailsService;

    @PayloadRoot(namespace = "http://springboot.com/courses",localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest req){
        GetCourseDetailsResponse getCourseDetailsResponse = new GetCourseDetailsResponse();
        Course course = courseDetailsService.findById(req.getId());
        getCourseDetailsResponse.setCourseDetails(mapCourseToCourseDetails(course));
        return getCourseDetailsResponse;
    }

    @PayloadRoot(namespace = "http://springboot.com/courses" , localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse getAllCourses(@RequestPayload GetAllCourseDetailsRequest req){
        GetAllCourseDetailsResponse res = new GetAllCourseDetailsResponse();
        List<Course> courses = this.courseDetailsService.findAll();
        for(Course course: courses) res.getCourseDetails().add(mapCourseToCourseDetails(course));
        return res;
    }

    @PayloadRoot(namespace = "http://springboot.com/courses" , localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse getAllCourses(@RequestPayload DeleteCourseDetailsRequest req){
        DeleteCourseDetailsResponse res = new DeleteCourseDetailsResponse();
        res.setStatus(courseDetailsService.deleteCourse(req.getId()));
        return res;
    }

    public CourseDetails mapCourseToCourseDetails(Course course){
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }
}
