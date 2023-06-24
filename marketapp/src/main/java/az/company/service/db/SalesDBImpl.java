package az.company.service.db;

import az.company.config.PersistenceConfig;
import az.company.model.Product;
import az.company.model.Sale;
import az.company.model.SalesItem;
import az.company.service.inter.SalesInter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class SalesDBImpl extends PersistenceConfig implements SalesInter {
    @Override
    public void addSales(List<SalesItem> salesItems) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        BigDecimal price = BigDecimal.valueOf(0);
        for (SalesItem salesItem : salesItems) {
            ProductDBImpl productDBImpl = new ProductDBImpl();
            Product product = productDBImpl.getProductByBarcode(salesItem.getProductBarCode());

            if (product.getCount() - salesItem.getSalesItemCount() != 0) {
                product.setCount(product.getCount() - salesItem.getSalesItemCount());
                productDBImpl.updateProduct(product.getBarCode(), product);
            }
            BigDecimal price1 = product.getPrice().multiply(BigDecimal.valueOf(salesItem.getSalesItemCount().longValue()));
            price = price.add(price1);
        }
        Sale sale = new Sale(null, UUID.randomUUID().toString(), price, salesItems, LocalDateTime.now());
        for (SalesItem salesItem : salesItems) {
            salesItem.setSales(sale);
        }
        sale.setSalesItems(salesItems);
        entityManager.persist(entityManager.merge(sale));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateSales(String salesNumber, Sale sale) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        Sale sale1 = getSalesBySalesNumber(salesNumber);
        sale.setId(sale1.getId());
        entityManager.merge(sale);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteSales(String salesNumber) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        Sale sale = getSalesBySalesNumber(salesNumber);
        entityManager.remove(entityManager.merge(sale));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Sale> getBeetweenTwoTime(LocalDateTime startTime, LocalDateTime endTime) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Sale> productTypedQuery = entityManager.createQuery("select s from Sale s where s.salesDate between :startTime and :endTime ", Sale.class);
        productTypedQuery.setParameter("startTime", startTime);
        productTypedQuery.setParameter("endTime", endTime);
        List<Sale> sales = productTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return sales;
    }

    @Override
    public List<Sale> getInOneDaySales(LocalDate localDate) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        LocalDateTime localDateTime=LocalDateTime.of(localDate,LocalTime.of(00,00));
        LocalDateTime localDateTime1=LocalDateTime.of(localDate,LocalTime.of(23,59));
        TypedQuery<Sale>saleTypedQuery=entityManager.createQuery("select s from Sale s where s.salesDate between :startTime and :endTime ",Sale.class);
        saleTypedQuery.setParameter("startTime",localDateTime);
        saleTypedQuery.setParameter("endTime",localDateTime1);
        List<Sale> sales=saleTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return sales;
    }

    @Override
    public List<Sale> getSalesPrice(BigDecimal startPrice, BigDecimal endPrice) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Sale> productTypedQuery = entityManager.createQuery("select s from Sale s where s.salesPrice between :startPrice and :endPrice ", Sale.class);
        productTypedQuery.setParameter("startPrice", startPrice);
        productTypedQuery.setParameter("endPrice", endPrice);
        List<Sale> sales = productTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return sales;
    }

    @Override
    public Sale getSalesBySalesNumber(String salesNumber) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Sale> saleTypedQuery = entityManager.createQuery("select s from Sale s where s.salesNumber=?1", Sale.class);
        saleTypedQuery.setParameter(1, salesNumber);
        Sale sale = saleTypedQuery.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return sale;
    }

    @Override
    public void returnSalesProduct(SalesItem salesItem, String salesNumber) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        ProductDBImpl productDBImpl = new ProductDBImpl();
        Product product = productDBImpl.getProductByBarcode(salesItem.getProductBarCode());

        Sale sale1 = getSalesBySalesNumber(salesNumber);
        SalesItem salesItem1 = sale1.getSalesItems().stream().filter(salesItem2 -> salesItem2.getProductBarCode().equals(salesItem.getProductBarCode())).findAny().get();
        if (sale1.getSalesItems().size() == 1 && salesItem1.getSalesItemCount() == salesItem.getSalesItemCount()) {
            deleteSales(salesNumber);
            product.setCount(product.getCount() + salesItem.getSalesItemCount());
            productDBImpl.updateProduct(product.getBarCode(), product);
        } else {
            salesItem1.setSalesItemCount(salesItem1.getSalesItemCount() - salesItem.getSalesItemCount());
            Integer endCount = salesItem1.getSalesItemCount();
            BigDecimal price = product.getPrice();
            BigDecimal endPrice = BigDecimal.valueOf(endCount).multiply(price);
            sale1.getSalesItems().remove(salesItem1);
            sale1.getSalesItems().add(salesItem1);
            sale1.setSalesPrice(endPrice);
            updateSales(salesNumber, sale1);
            product.setCount(product.getCount() + salesItem.getSalesItemCount());
            productDBImpl.updateProduct(product.getBarCode(), product);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void returnAllSales(List<SalesItem> salesItems) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        ProductDBImpl productDBImpl = new ProductDBImpl();
        for (SalesItem salesItem : salesItems) {
            Sale sale = getSalesBySalesNumber(salesItem.getSales().getSalesNumber());
            Product product = productDBImpl.getProductByBarcode(salesItem.getProductBarCode());
            deleteSales(salesItem.getSales().getSalesNumber());
            product.setCount(product.getCount() + salesItem.getSalesItemCount());
            productDBImpl.updateProduct(product.getBarCode(), product);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Sale> getAllSales() {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Sale> saleTypedQuery = entityManager.createQuery("select s from Sale s", Sale.class);
        List<Sale> sales = saleTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return sales;
    }

}
