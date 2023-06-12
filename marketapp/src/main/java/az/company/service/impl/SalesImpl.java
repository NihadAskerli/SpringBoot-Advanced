package az.company.service.impl;

import az.company.model.Product;
import az.company.model.Sale;
import az.company.model.SalesItem;
import az.company.service.inter.SalesInter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static az.company.service.impl.ProductImpl.products;

public class SalesImpl implements SalesInter {
   public static List<Sale>sales=new ArrayList<>();

   public Product getProductByBarcode(String barCode) {
      Product product1=null;

      for (Product product:products){
         if (product.getBarCode().equals(barCode)){
            product1=product;
         }
      }
      return product1;
   }

   @Override
   public void addSales(List<SalesItem> salesItems) {

       BigDecimal price=BigDecimal.valueOf(0);
       for (SalesItem salesItem:salesItems){
          Product product=getProductByBarcode(salesItem.getProductBarCode());
          products.remove(product);
          if(product.getCount()-salesItem.getSalesItemCount()!=0){
             product.setCount(product.getCount()-salesItem.getSalesItemCount());
             products.add(product);
          }
          BigDecimal price1= product.getPrice().multiply(BigDecimal.valueOf(salesItem.getSalesItemCount().longValue()));
          price=price.add(price1);
       }
       sales.add(new Sale(UUID.randomUUID().toString(),price,salesItems,LocalDateTime.now()));
   }

   @Override
   public List<Sale> getBeetweenTwoTime(LocalDateTime startTime, LocalDateTime endTime) {
      List<Sale> filteredListByDate = new ArrayList<>();

      for (Sale sale:sales){
         if ((sale.getSalesDate().compareTo(startTime)) >=0 && (sale.getSalesDate().compareTo(endTime) <=0)){
            filteredListByDate.add(sale);
         }
      }
      return filteredListByDate;
   }

   @Override
   public List<Sale> getInOneDaySales(LocalDate localDate) {
      List<Sale> filteredSalInOneDay=new ArrayList<>();

      for (Sale sale:sales){
         if (sale.getSalesDate().equals(localDate)){
            filteredSalInOneDay.add(sale);
         }
      }
      return filteredSalInOneDay;
   }

   @Override
   public List<Sale> getSalesPrice(BigDecimal startPrice, BigDecimal endPrice) {
      List<Sale> filteredListByPrice=new ArrayList<>();

      for (Sale sale:sales){
         if (sale.getSalesPrice().compareTo(startPrice) >=0 && sale.getSalesPrice().compareTo(endPrice) <=0 ){
            filteredListByPrice.add(sale);
         }
      }
      return filteredListByPrice;
   }

   @Override
   public Sale getSalesByBarcode(String salesNumber) {
      Sale saleAll=null;

      for (Sale sale:sales){
         if (sale.getSalesNumber().equals(salesNumber)){
            saleAll=sale;
         }
      }
      return saleAll;
   }

   public void returnSalesProduct(SalesItem salesItem,String salesNumber){
      Product product=getProductByBarcode(salesItem.getProductBarCode());
      Sale sale1=sales.stream().filter(sale -> sale.getSalesNumber().equals(salesNumber)).findFirst().get();
      SalesItem salesItem1=sale1.getSalesItems().stream().filter(salesItem2 -> salesItem2.getProductBarCode().equals(salesItem.getProductBarCode())).findFirst().get();
      if(sale1.getSalesItems().size()==1 && salesItem1.getSalesItemCount()==salesItem.getSalesItemCount()){
         sales.remove(sale1);
         products.remove(product);
         product.setCount(product.getCount()+salesItem.getSalesItemCount());
         products.add(product);
      } else {
         sales.remove(sale1);
//         sale1.setSalesPrice();
         salesItem1.setSalesItemCount(salesItem1.getSalesItemCount()-salesItem.getSalesItemCount());
         Integer endCount=salesItem1.getSalesItemCount();
         BigDecimal price=product.getPrice();
         BigDecimal endPrice=BigDecimal.valueOf(endCount).multiply(price);
         sale1.getSalesItems().remove(salesItem1);
         sale1.getSalesItems().add(salesItem1);
         sale1.setSalesPrice(endPrice);
         sales.add(sale1);
         products.remove(product);
         product.setCount(product.getCount()+salesItem.getSalesItemCount());
         products.add(product);
      }

   }

   public void returnAllSales(List<SalesItem> salesItems){
      for (SalesItem salesItem:salesItems){
         Product product= getProductByBarcode(salesItem.getProductBarCode());
         sales.remove(sales.stream().filter(sale -> sale.getSalesDate().equals(salesItem.getLocalDateTime())).findFirst().get());
         products.remove(product);
         product.setCount(product.getCount()+salesItem.getSalesItemCount());
         products.add(product);


      }
   }

}
