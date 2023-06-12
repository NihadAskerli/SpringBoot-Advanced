package az.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
   private String barCode;
   private String name;
   private ProductCategory productCategory;
   private BigDecimal price;
   private Integer count;
}
