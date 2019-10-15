package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Instructor;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface InstructorService
{
    ArrayList<Instructor> findAll();

    List<Instructor> findAllPageable(Pageable pageable);
}
