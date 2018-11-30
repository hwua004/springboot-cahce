package com.hwua.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private String sex;
    private Integer age;
}
