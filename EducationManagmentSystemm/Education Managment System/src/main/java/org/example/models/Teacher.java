package org.example.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Long id;
    private String finCode;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;
    private String speciality;
    private List<Student> students;

}

