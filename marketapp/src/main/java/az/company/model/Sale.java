package az.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private String salesNumber;
    private BigDecimal salesPrice;
    private List<SalesItem> salesItems;
    private LocalDateTime salesDate;
}
