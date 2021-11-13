package com.springboot.coursessoapwebservices.models;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Course {
    private int id ;
    private String name;
    private String description;
}
