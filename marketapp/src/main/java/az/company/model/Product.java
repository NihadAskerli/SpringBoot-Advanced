package az.company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
   @Id
   @SequenceGenerator(name = "pro_increment",allocationSize =1 )
   @GeneratedValue(generator = "pro_increment")
   private Long id;
   private String barCode;
   private String name;
   @Enumerated
   private ProductCategory productCategory;
   private BigDecimal price;
   private Integer count;
}
