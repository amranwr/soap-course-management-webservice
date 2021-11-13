package com.springboot.coursessoapwebservices.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.WsdlDefinition;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig {
    @Bean
    ServletRegistrationBean messageDispatcherServlet(ApplicationContext ctx){
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(ctx);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
    }

    @Bean(name = "courses")
    DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CoursePort");
        definition.setTargetNamespace("http://springboot.com/courses");
        definition.setLocationUri("/ws");
        definition.setSchema(xsdSchema);
        return definition;
    }

    @Bean
    XsdSchema courseSchema(){
        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }
}
