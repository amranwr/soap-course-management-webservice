package com.springboot.coursessoapwebservices.soap;

import com.springboot.courses.CourseDetails;
import com.springboot.courses.GetCourseDetailsRequest;
import com.springboot.courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class CourseDetailsEndPoint {
    @PayloadRoot(namespace = "http://springboot.com/courses",localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest req){
        GetCourseDetailsResponse getCourseDetailsResponse = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(req.getId());
        courseDetails.setName("amrooo");
        courseDetails.setDescription("heelloo bitches");
        getCourseDetailsResponse.setCourseDetails(courseDetails);
        return getCourseDetailsResponse;
    }
}
