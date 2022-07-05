package com.student1.CRUD.student.controller;

import com.student1.CRUD.student.dto.studentDTO;
import com.student1.CRUD.student.entity.student;
import com.student1.CRUD.student.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.student1.CRUD.student.repository.studentRepository;

import java.util.List;
import java.util.Optional;

class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Long id) {
        super("Could not find student " + id);
    }
}

@RestController
@RequestMapping(path = "/api/v1")
public class studentController {
    @Autowired
    private studentService studentService;
//    private studentRepository studentRepository;

    // list all
    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<studentDTO> getAllStudent(){
        return studentService.findAll();
    }

    // find by id
    @GetMapping("/findById/{id}")
    public studentDTO findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    // find by name
    @GetMapping("/findByName/{name}")
    public @ResponseBody List<studentDTO> getStudentByName(@PathVariable String name) {
        return studentService.searchByName(name);
    }

    // find by email
    @GetMapping("/findByEmail/{email}")
    public @ResponseBody List<studentDTO> getStudentByEmail(@PathVariable String email) {
        return studentService.searchByEmail(email);
    }

    // add new
    @PostMapping("/add")
    public String addStudent(@RequestBody studentDTO stdDTO){
        studentService.create(stdDTO);
        return "Success";
    }

    // update
    @PutMapping("/update/{id}")
    public void updateStudent(@RequestBody studentDTO newStdUpdate,@PathVariable Long id){
        studentService.update(newStdUpdate, id);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.delete(id);
    }

}
