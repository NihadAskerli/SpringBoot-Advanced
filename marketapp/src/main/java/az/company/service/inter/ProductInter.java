package az.company.service.inter;

import az.company.model.Product;
import az.company.model.ProductCategory;

import java.math.BigDecimal;
import java.util.List;

public interface ProductInter {

    void addProduct(Product product);

    void updateProduct(String barCode, Product product);

    void deleteProduct(String barCode);

    List<Product> getProductByCategory(ProductCategory productCategory);

    void getProductByMenuCategory();

    List<Product> getProductByPrice(BigDecimal bigDecimal1, BigDecimal bigDecimal2);

    Product getProductByName(String name);

    Product getProductByBarcode(String barCode);

    List<Product> getAllProducts();
}
