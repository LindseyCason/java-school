package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.number.OrderingComparison.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(value = CourseController.class, secure = false)
//@EnableAutoConfiguration(exclude = {SecurityConfig})

public class CourseControllerIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.webAppContextSetup( webApplicationContext );
    }
    @Test
    public void AResponseTime()
    {
        given().when().get("/courses/courses").then().time(lessThan(5000L));

    }
    @Test
    public void BResponseTime()
    {
        given().when().post("/courses/course/add").then().time(lessThan(5000L));
    }

    public List<Course> courseList;

    @Test
    public void ANewCourse() throws Exception
    {

        Course c1 = new Course("lindsey");
//        courseList.add(c1);

        ObjectMapper mapper = new ObjectMapper();
        String courseString = mapper.writeValueAsString(c1);
//        System.out.println(courseString);

        given().contentType( "application/json" ).body( courseString ).when().post("/courses/course/add").then().statusCode( 201 );


    }

}
