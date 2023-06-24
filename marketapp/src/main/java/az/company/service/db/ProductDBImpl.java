package az.company.service.db;

import az.company.config.PersistenceConfig;
import az.company.model.Product;
import az.company.model.ProductCategory;
import az.company.service.inter.ProductInter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDBImpl extends PersistenceConfig implements ProductInter {
    @Override
    public void addProduct(Product product) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entityManager.merge(product));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateProduct(String barCode, Product product) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        Product product1 = getProductByBarcode(barCode);
        product.setId(product.getId());
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteProduct(String barCode) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        Product product = getProductByBarcode(barCode);
        entityManager.remove(entityManager.merge(product));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Product> getProductByCategory(ProductCategory productCategory) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("select p from Product p where p.productCategory=?1", Product.class);
        productTypedQuery.setParameter(1, productCategory);
        List<Product> product = productTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public void getProductByMenuCategory() {
        Boolean aBoolean = true;

        Product product = null;
        List<Product> products = new ArrayList<>();

        System.out.println(
                " 1-i  basanda   MEAT_AND_GOURMET,\n" +
                        " 2-ni basanda   DRY_FOOD,\n" +
                        " 3-u  basanda   SWEETS,\n" +
                        " 4-u  basanda   DRINKS,\n" +
                        " 5-i  basanda   FRUIT_AND_VEGETABLES,\n" +
                        " 6-ni basanda   DAIRY_PRODUCTS,\n" +
                        " 7-ni basanda   CLEANİNG_PRODUCTS;");

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Secmek istediyiniz operation nomresini daxil edin: ");
        int operation2 = scanner2.nextInt();

        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Product> productTypedQuery=entityManager.createQuery("select p from Product p where p.productCategory=?1",Product.class);


        while (aBoolean) {
            if (operation2 == 1) {
               productTypedQuery.setParameter(1,ProductCategory.MEAT_AND_GOURMET);
               List<Product>products1=productTypedQuery.getResultList();
               products1.stream().forEach(System.out::println);
            } else if (operation2 == 2) {
                if (product.getProductCategory().equals(ProductCategory.DRY_FOOD)) {
                    products.add(product);
                    for (Product product1 : products) {
                        System.out.println(product1);
                    }
                }
            } else if (operation2 == 3) {
                if (product.getProductCategory().equals(ProductCategory.SWEETS)) {
                    products.add(product);
                    for (Product product1 : products) {
                        System.out.println(product1);
                    }
                }
            } else if (operation2 == 4) {
                if (product.getProductCategory().equals(ProductCategory.DRINKS)) {
                    products.add(product);
                    for (Product product1 : products) {
                        System.out.println(product1);
                    }
                }
            } else if (operation2 == 5) {
                if (product.getProductCategory().equals(ProductCategory.FRUIT_AND_VEGETABLES)) {
                    products.add(product);
                    for (Product product1 : products) {
                        System.out.println(product1);
                    }
                }
            } else if (operation2 == 6) {
                if (product.getProductCategory().equals(ProductCategory.DAIRY_PRODUCTS)) {
                    products.add(product);
                    for (Product product1 : products) {
                        System.out.println(product1);
                    }
                }
            } else if (operation2 == 7) {
                if (product.getProductCategory().equals(ProductCategory.CLEANİNG_PRODUCTS)) {
                    products.add(product);
                    for (Product product1 : products) {
                        System.out.println(product1);
                    }
                }
            } else {
                aBoolean = false;
            }
        }
    }

    @Override
    public List<Product> getProductByPrice(BigDecimal firstPrice, BigDecimal endPrice) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("select p from Product p where p.price between ?1 and ?2 ", Product.class);
        productTypedQuery.setParameter(1, firstPrice);
        productTypedQuery.setParameter(2, endPrice);
        List<Product> product = productTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public Product getProductByName(String name) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("select p from Product p where p.name=?1", Product.class);
        productTypedQuery.setParameter(1, name);
        Product product = productTypedQuery.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public Product getProductByBarcode(String barCode) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("select p from Product p where p.barCode=?1", Product.class);
        productTypedQuery.setParameter(1, barCode);
        Product product = productTypedQuery.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("select p from Product p", Product.class);
        List<Product> products = productTypedQuery.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }
}
