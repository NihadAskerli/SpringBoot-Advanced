package com.example.springjpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person{
    private String number;
    private String point;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                "surname="+getSurname()+'\''+
                "number='" + number + '\'' +
                ", point='" + point + '\'' +
                '}';
    }
}
