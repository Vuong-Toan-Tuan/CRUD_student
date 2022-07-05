package com.student1.CRUD.student.service;

import com.student1.CRUD.student.dto.studentDTO;

import java.util.List;

//import java.util.List;

public interface studentService {
    Iterable<studentDTO> findAll();
    studentDTO findById(Long id);
    studentDTO create(studentDTO studentdto);
    void update(studentDTO studentdto, Long id);
    void delete(Long id);
    List<studentDTO> searchByName(String name);
    List<studentDTO> searchByEmail(String email);
}
