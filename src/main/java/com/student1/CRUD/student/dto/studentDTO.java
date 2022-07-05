package com.student1.CRUD.student.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class studentDTO {

    private Long Id;

    @NotBlank(message = "Name may not be blank")
    private String name;

    @NotNull @Email
    private String email;

    @NotNull @Min(1) @Max(100)
    private int age;

    public studentDTO(){

    }

//    public Long getId(){
//        return this.Id;
//    }
//    public void setId(Long id){
//        this.Id = id;
//    }
//    public String getName(){
//        return this.name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//    public String getEmail(){
//        return this.email;
//    }
//    public void setEmail(String email){
//        this.email = email;
//    }
//    public Integer getAge(){
//        return this.age;
//    }
//    public void setAge(int age){
//        this.age = age;
//    }
}
