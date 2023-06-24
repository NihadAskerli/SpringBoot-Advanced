package org.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static Long lastId=0l;
    private Double total;
    @OneToMany(mappedBy = "sale",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Item> items;
    private LocalDateTime date;
//    {
//        lastId++;
//        id=lastId;
//    }

}
