package az.company.service.impl;

import az.company.model.Product;
import az.company.model.ProductCategory;
import az.company.service.inter.ProductInter;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductImpl implements ProductInter {
    public static List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(String barCode, Product product) {

        for (Product product2 : products) {
            if (product2.getBarCode().equals(barCode)) {
                product2.setName(product.getName());
                product2.setCount(product.getCount());
                product2.setProductCategory(product.getProductCategory());
                product2.setPrice(product.getPrice());
                product = product2;
                products.set(barCode.indexOf(barCode), product);
            }
        }
    }

    @Override
    public void deleteProduct(String barCode) {
        for (Product product : products) {
            if (product.getBarCode().equals(barCode)) {
                products.remove(product);
                System.out.println("silindi");
            }
        }
        System.out.println("silindi");
    }

    @Override
    public List<Product> getProductByCategory(ProductCategory productCategory) {
        List<Product> products1 = new ArrayList<>();

        for (Product product : products) {
            if (product.getProductCategory().equals(productCategory)) {
                products1 = products;
                System.out.println(products1);
            }
        }
        return products1;
    }

    public void getProductByMenuCategory() {
        Boolean aBoolean = true;

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

        while (aBoolean) {
            if (operation2 == 1) {
                products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.MEAT_AND_GOURMET)).forEach(System.out::println);
            } else if (operation2 == 2) {
                products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.DRY_FOOD)).forEach(System.out::println);
            } else if (operation2 == 3) {
                products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.SWEETS)).forEach(System.out::println);
            } else if (operation2 == 4) {
                products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.DRINKS)).forEach(System.out::println);
            } else if (operation2 == 5) {
                products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.FRUIT_AND_VEGETABLES)).forEach(System.out::println);
            } else if (operation2 == 6) {
                products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.DAIRY_PRODUCTS)).forEach(System.out::println);
            } else if (operation2 == 7) {
                products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.CLEANİNG_PRODUCTS)).forEach(System.out::println);
            } else {
                aBoolean = false;
            }
        }
    }


    @Override
    public List<Product> getProductByPrice(BigDecimal firstPrice, BigDecimal endPrice) {
        List<Product> products1 = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice().compareTo(firstPrice) >= 0 && product.getPrice().compareTo(endPrice) <= 0) {
                products1 = products;
                System.out.println(products1);
            }
        }
        return products1;
    }

    @Override
    public Product getProductByName(String name) {
        Product products1 = null;

        for (Product product : products) {
            if (product.getName().equals(name)) {
                products1 = product;
                System.out.println(products1);
            }
        }
        return products1;
    }

    @Override
    public Product getProductByBarcode(String barCode) {
        Product products1 = null;
        for (Product product : products) {
            if (product.getBarCode().equals(barCode)) {
                products1 = product;
                System.out.println(products1);
            }
        }
        return products1;
    }

    @Override
    public List<Product> getAllProducts() {

        return products;
    }
}
