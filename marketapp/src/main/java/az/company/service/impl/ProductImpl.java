package az.company.service.impl;

import az.company.model.Product;
import az.company.model.ProductCategory;
import az.company.service.inter.ProductInter;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductImpl implements ProductInter {
    public static List<Product>products=new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(String barCode,Product product) {

        for (Product product2:products){
            if (product2.getBarCode().equals(barCode)){
                product2.setName(product.getName());
                product2.setCount(product.getCount());
                product2.setProductCategory(product.getProductCategory());
                product2.setPrice(product.getPrice());
                product=product2;
                products.set(barCode.indexOf(barCode),product);
            }
        }
    }

    @Override
    public void deleteProduct(String barCode) {
        for (Product product:products){
            if (product.getBarCode().equals(barCode)){
                products.remove(product);
                System.out.println("silindi");
            }
        }
        System.out.println("silindi");
    }

    @Override
    public List<Product> getProductByCategory(ProductCategory productCategory) {
        List<Product>products1=new ArrayList<>();

        for (Product product:products){
            if (product.getProductCategory().equals(productCategory)){
                products1=products;
                System.out.println(products1);
            }
        }
        return products1;
    }

    @Override
    public List<Product> getProductByPrice(BigDecimal firstPrice, BigDecimal endPrice) {
        List<Product>products1=new ArrayList<>();
                                                            //10azn - 50azn
        for (Product product:products){
            if (product.getPrice().compareTo(firstPrice) >=0 && product.getPrice().compareTo(endPrice) <=0){
                products1=products;
                System.out.println(products1);
            }
        }
        return products1;
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> products1=new ArrayList<>();

        for (Product product:products){
            if (product.getName().equals(name)){
                products1=products;
                System.out.println(products1);
            }
        }
        return products1;
    }

    @Override
    public List<Product> getProductByBarcode(String barCode) {
        List<Product> products1=new ArrayList<>();

        for (Product product:products){
            if (product.getBarCode().equals(barCode)){
                products1=products;
                System.out.println(products1);
            }
        }
        return products1;
    }
}
