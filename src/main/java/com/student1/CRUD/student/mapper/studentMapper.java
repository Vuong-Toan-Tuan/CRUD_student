package com.student1.CRUD.student.mapper;
import com.student1.CRUD.student.entity.student;
import com.student1.CRUD.student.dto.studentDTO;

import javax.servlet.http.PushBuilder;

public class studentMapper {
    private static studentMapper INSTANCE;
    public static studentMapper getInstance() {
        if(INSTANCE == null){
            INSTANCE = new studentMapper();
        }
        return INSTANCE;
    };

    public static student getEntityFromDTO(studentDTO studentdto){
        student newStudentEntity = new student();
        newStudentEntity.setName(studentdto.getName());
        newStudentEntity.setEmail(studentdto.getEmail());
        newStudentEntity.setAge(studentdto.getAge());
        return newStudentEntity;
    };

    public static studentDTO getDTOFromEntity(student studententity){
        studentDTO newStudentDTO = new studentDTO();
        newStudentDTO.setId(studententity.getId());
        newStudentDTO.setName(studententity.getName());
        newStudentDTO.setEmail(studententity.getEmail());
        newStudentDTO.setAge(studententity.getAge());
        return newStudentDTO;
    };
}
