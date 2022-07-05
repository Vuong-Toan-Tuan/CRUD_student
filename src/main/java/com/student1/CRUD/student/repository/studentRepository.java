package com.student1.CRUD.student.repository;

import com.student1.CRUD.student.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

//import java.util.Optional;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
    @Query( value = "Select * from student where name like %?1%",
            nativeQuery = true)
    List<student> findAllByName(String name);

    @Query( value = "Select * from student where email like %?1%",
            nativeQuery = true)
    List<student> findAllByEmail(String email);
}
