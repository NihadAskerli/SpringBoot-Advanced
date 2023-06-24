package az.company.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salesitem")
public class SalesItem {
    @Id
    @SequenceGenerator(name = "salesitem_increment",allocationSize =1 )
    @GeneratedValue(generator = "salesitem_increment")
    private Long id;
    private String productBarCode;
    private Integer salesItemCount;
    private LocalDateTime localDateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesitem_id" ,referencedColumnName = "id")
    private Sale sales;


}
