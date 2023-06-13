package org.example.models;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(generator = "seq-student", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "seq-student", allocationSize = 1)
    private Integer id;

    @Column(name = "studentName",unique = true)
    private String studetnName;
}
