package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value= CourseController.class, secure = false)

public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    private List<Course> courseList;

    @Before
    public void setUp() throws Exception {

        courseList = new ArrayList<>();

        Course c1 = new Course("lindsey");
        c1.setCourseid(7);
        ArrayList<Course>   courses = new ArrayList<>(  );
        courseList.add(c1);





    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllCourses() throws Exception {

        String apiUrl = "/courses/courses";
        Mockito.when(courseService.findAll(Pageable.unpaged())).thenReturn( (ArrayList<Course>) courseList );

        RequestBuilder rb = MockMvcRequestBuilders.get( apiUrl ).accept( MediaType.APPLICATION_JSON );

        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper(  );
        String er = mapper.writeValueAsString( courseList );
        assertEquals("unit text adding controller test", er,tr );

    }
    @Test
    public void listAllCoursesByPage() {
    }

    @Test
    public void getCountStudentsInCourses() {
    }

    @Test
    public void deleteCourseById() {
    }

    @Test
    public void getCourseById() {
    }

    @Test
    public void addNewCourse() throws Exception {

        String apiUrl = "/courses/course/add";

        // build a course
        ArrayList<Course> thisCourse = new ArrayList<>();
        ArrayList<Instructor> thisInstructor = new ArrayList<>();
        Course c1 = new Course("lindsey");
        c1.setCourseid(7);
        ArrayList<Course>   courses = new ArrayList<>(  );
        courseList.add(c1);;

        ObjectMapper mapper = new ObjectMapper();
        String courseString = mapper.writeValueAsString(c1);

        Mockito.when(courseService.save(any(Course.class))).thenReturn(c1);
//IS THIS ALSO THE TEST FOR SAVE BECASUE OF THE ABOVE??
        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(courseString);

        mockMvc.perform(rb).andExpect(status().isCreated()).andDo( MockMvcResultHandlers.print());

    }
}