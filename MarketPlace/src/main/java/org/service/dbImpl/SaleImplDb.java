package org.service.dbImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.config.AbstractDAO;
import org.models.Item;
import org.models.Product;
import org.models.Sale;
import org.service.inter.ProductInter;
import org.service.inter.SaleInter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SaleImplDb extends AbstractDAO implements SaleInter {
    public  ProductImplDb productImplDb = new ProductImplDb();

    @Override
    public List<Sale> showSale() {
        EntityManager em = entityManager();
        em.getTransaction().begin();
        String jpql = "SELECT s FROM Sale s";
        TypedQuery<Sale> query = em.createQuery(jpql, Sale.class);
        List<Sale> saleList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return saleList;
    }

    @Override
    public Sale showSaleById(Long id) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        String jpql = "Select s from Sale s where s.id = :id";
        TypedQuery<Sale> query = entityManager.createQuery(jpql, Sale.class);
        Sale sale = query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return sale;
    }

    @Override
    public List<Sale> showSaleByPrice(Double minPrice, Double maxPrice) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        String jpql = "select s from Sale s where s.total between :minPrice and :maxPrice";
        TypedQuery<Sale> query = entityManager.createQuery(jpql, Sale.class);
        List<Sale> saleList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return saleList;
    }

    @Override
    public List<Sale> showSaleByDate(LocalDate time) {
        EntityManager em = entityManager();
        em.getTransaction().begin();
        try {
            String jpql = "SELECT s FROM Sale s WHERE s.date = :saleDate";
            TypedQuery<Sale> query = em.createQuery(jpql, Sale.class);
            query.setParameter("saleDate", time);

            return query.getResultList();
        } finally {
            em.getTransaction().commit();
            em.close();
        }

    }

    @Override
    public List<Sale> showSaleByDuration(LocalDateTime startTime, LocalDateTime endTime) {
        EntityManager em = entityManager();
        em.getTransaction().begin();
        try {
            String jpql = "SELECT s FROM Sale s WHERE s.date >= :startDate AND s.date <= :endDate";
            TypedQuery<Sale> query = em.createQuery(jpql, Sale.class);
            query.setParameter("startDate", startTime);
            query.setParameter("endDate", endTime);
            return query.getResultList();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void addSale(List<Item> items) {
        EntityManager em = entityManager();
        em.getTransaction().begin();
        double total = 0;
        Sale sale = new Sale(null, null, null, LocalDateTime.now());

        for (Item item : items) {
            total += item.getTotal();
            item.setSale(sale);
        }
        sale.setTotal(total);
        sale.setItems(items);
        em.persist(em.merge(sale)); //m1+1 --> merge tesdiqleyirem ki bunnan yoxdu bazada
        for (Item item : items) {
            Product product = productImplDb.getProductByBarcode(item.getBarcode());
            productImplDb.updateProductAmount(product.getId(), product.getAmount() - item.getCount());
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeSale(Long id) {
        EntityManager em = entityManager();
        em.getTransaction().begin();
        Sale sale = em.find(Sale.class, id);

        for (Item item : sale.getItems()) {

           Product product=productImplDb.getProductByBarcode(item.getBarcode());
           product.setAmount(product.getAmount()+item.getCount());
            productImplDb.updateProductAmount(product.getId(),product.getAmount());
        }
        if (sale != null) {
            em.remove(sale);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeItem(Long saleId, String barcode) {
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();

            Sale sale = em.find(Sale.class, saleId);

            Item itemToRemove = null;
            for (Item item : sale.getItems()) {
                if (item.getBarcode().equals(barcode)) {
                    itemToRemove = item;
                    break;
                }
            }
            if (itemToRemove != null) {
                sale.getItems().remove(itemToRemove);

                sale.setTotal(sale.getTotal() - itemToRemove.getTotal());
                em.merge(sale);
                em.getTransaction().commit();
            }

        } finally {
            em.close();
        }
    }
}