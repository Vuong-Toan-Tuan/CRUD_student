package com.student1.CRUD.student.service.impl;

import com.student1.CRUD.student.dto.studentDTO;
import com.student1.CRUD.student.entity.student;
import com.student1.CRUD.student.mapper.studentMapper;
import com.student1.CRUD.student.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.student1.CRUD.student.repository.studentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Long id) {
        super("Could not find student " + id);
    }
}

@Service
@Transactional(rollbackFor = Throwable.class)
public class studentServiceImpl implements studentService {

    @Autowired
    private studentRepository studentRepository;

    @Override
    public Iterable<studentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> studentMapper.getInstance().getDTOFromEntity(student))
                .collect(Collectors.toList());
    }

    @Override
    public studentDTO findById(Long id) {
        student std = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        studentDTO stdDTO = studentMapper.getInstance().getDTOFromEntity(std);
        return stdDTO;
    }

    @Override
    public studentDTO create(studentDTO studentdto) {
        student newStudent = studentMapper.getInstance().getEntityFromDTO(studentdto);
        newStudent.setName(studentdto.getName());
        newStudent.setEmail(studentdto.getEmail());
        newStudent.setAge(studentdto.getAge());
        return studentMapper.getInstance().getDTOFromEntity(studentRepository.save(newStudent));
    }

    @Override
    public void update(studentDTO studentdto, Long id) {
        studentDTO stdFind = findById(id);
        if(stdFind == null){
            System.out.println("This id is currently not available");
        }else{
            student std1 = studentMapper.getInstance().getEntityFromDTO(studentdto);
            std1.setId(id);
            studentRepository.save(std1);
        }
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<studentDTO> searchByName(String name) {
//        List<studentDTO> stdDTO;
//        List<student> stdEntity = studentRepository.findAllByName(name); // dang tra 1 list
//        stdEntity.forEach(a -> {
//            studentDTO stdDTO1 = studentMapper.getInstance().getDTOFromEntity(a); // map entity qua dto
//            stdDTO.add(stdDTO1);
//        });
//        for (student i : stdEntity){
//            studentDTO stdDTO1 = studentMapper.getInstance().getDTOFromEntity(i);
//            stdDTO.add(stdDTO1);
//        }
        return studentRepository.findAllByName(name).stream()
                .map(student -> studentMapper.getInstance().getDTOFromEntity(student))
                .collect(Collectors.toList());
    }

    @Override
    public List<studentDTO> searchByEmail(String email) {
        return studentRepository.findAllByEmail(email).stream()
                .map(student -> studentMapper.getInstance().getDTOFromEntity(student))
                .collect(Collectors.toList());
    }
}
