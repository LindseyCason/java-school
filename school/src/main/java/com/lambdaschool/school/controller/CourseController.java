package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController
{
    @Autowired
    private CourseService courseService;

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping(value = "/courses", produces = {"application/json"})
    public ResponseEntity<?> listAllCourses()
    {
        logger.info("endpoint /courses has been accessed");
        ArrayList<Course> myCourses = courseService.findAll();
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    @GetMapping(value = "/course/paging", produces = {"application/json"})
    public ResponseEntity<?> listAllCoursesByPage(@PageableDefault(page=0, size=3) Pageable pageable){
        List<Course> myCourses = courseService.findAllPageable(pageable);
        return new ResponseEntity<>( myCourses, HttpStatus.OK );
    }



    @GetMapping(value = "/studcount", produces = {"application/json"})
    public ResponseEntity<?> getCountStudentsInCourses()
    {
        logger.info("enpoint /courses/studcount has been accessed");
        return new ResponseEntity<>(courseService.getCountStudentsInCourse(),
                HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseid}")
    public ResponseEntity<?> deleteCourseById(@PathVariable long courseid)
    {
        logger.info("Delete endpoint /courses/:id has been accessed" + courseid);
        courseService.delete(courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}