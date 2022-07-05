package com.student1.CRUD.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    public String name;
    public String email;
    public int age;

    public student() {

    }

    public Long getId(){
        return this.Id;
    }
    public void setId(Long id){
        this.Id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
