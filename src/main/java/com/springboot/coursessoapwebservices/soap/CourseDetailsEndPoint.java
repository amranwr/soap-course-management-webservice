package com.springboot.coursessoapwebservices.soap;

import com.springboot.courses.CourseDetails;
import com.springboot.courses.GetCourseDetailsRequest;
import com.springboot.courses.GetCourseDetailsResponse;
import com.springboot.coursessoapwebservices.models.Course;
import com.springboot.coursessoapwebservices.services.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
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
    public CourseDetails mapCourseToCourseDetails(Course course){
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }
}
