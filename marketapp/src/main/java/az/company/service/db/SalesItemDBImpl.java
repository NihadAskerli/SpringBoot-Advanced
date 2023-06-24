package az.company.service.db;

import az.company.config.PersistenceConfig;
import az.company.model.SalesItem;
import az.company.service.inter.SalesItemInter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SalesItemDBImpl extends PersistenceConfig implements SalesItemInter {
    public List<SalesItem> getSalesItemsBysalesNumber(String salesNumber) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<SalesItem> productTypedQuery = entityManager.createQuery("select s from SalesItem s where s.sales.salesNumber=?1", SalesItem.class);
        productTypedQuery.setParameter(1, salesNumber);
        List<SalesItem> salesItems = productTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return salesItems;
    }

}
