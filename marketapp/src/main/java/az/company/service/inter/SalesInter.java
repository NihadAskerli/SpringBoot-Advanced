package az.company.service.inter;

import az.company.model.Product;
import az.company.model.Sale;
import az.company.model.SalesItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SalesInter {

    void addSales(List<SalesItem> salesItems);

    void updateSales(String salesNumber, Sale sale);

    void deleteSales(String salesNumber);

    List<Sale> getBeetweenTwoTime(LocalDateTime localDateTime1, LocalDateTime localDateTime2);

    List<Sale> getInOneDaySales(LocalDate localDate);

    List<Sale> getSalesPrice(BigDecimal salesPrice1, BigDecimal salesPrice2);

    Sale getSalesBySalesNumber(String salesNumber);

    void returnSalesProduct(SalesItem salesItem, String salesNumber);

    void returnAllSales(List<SalesItem> salesItems);

    List<Sale> getAllSales();
}
