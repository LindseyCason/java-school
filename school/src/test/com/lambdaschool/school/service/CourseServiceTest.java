package com.lambdaschool.school.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    //mocks - fake data
    //stubs - coe that forces a return value
    //
    //Java- calls everything mock
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {

    }

    @Test
    void findAllPageable() {
    }

    @Test
    void findCourseById() {
    }

    @Test
    void getCountStudentsInCourse() {
    }

    @Test
    void delete() {
    }
}