package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import com.lambdaschool.school.exceptions.ResourceNotFoundException;
import com.lambdaschool.school.model.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//always include RunWith^
@SpringBootTest(classes = SchoolApplication.class)
//the class above is the MAIN class of your application
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks( this );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void AfindAll() {
        assertEquals( 6, courseService.findAll( Pageable.unpaged() ).size() );

    }


    //ADD SAVE TEST HERE//
    @Test
    public void ZSave() {
        Course c9 = new Course("lindsey");
        String courseName = courseService.save(c9).getCoursename();
        System.out.println("****************" + courseName);
        assertEquals( "lindsey", courseName);
    }

    @Test
    public void Ydelete() {
        courseService.delete( 6 );
        assertEquals( 5, courseService.findAll( Pageable.unpaged() ).size() );
    }

    @Test(expected = EntityNotFoundException.class)
    public void XNoDelete() {
        courseService.delete( 143 );
        assertEquals( 6, courseService.findAll( Pageable.unpaged() ).size() );
    }

    @Test
    public void CfindCourseById() {
        assertEquals( "T Node.js", courseService.findCourseById( 3 ).getCoursename() );
    }
}