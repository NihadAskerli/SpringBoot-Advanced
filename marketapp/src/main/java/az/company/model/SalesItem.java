package az.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesItem {
//    private String salesItemNumber;
    private String productBarCode;
    private Integer salesItemCount;
    private LocalDateTime localDateTime;
//    private String casher;


}
