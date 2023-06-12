package az.company.model;

import az.company.service.impl.ProductImpl;
import az.company.service.impl.SalesImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    ProductImpl productImpl = new ProductImpl();
    SalesImpl salesImpl=new SalesImpl();

    public Product addProduct() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("product melumatlari");
        System.out.println("productin barcode-ni daxil edin");
        String barcode = sc1.nextLine();
        System.out.println("productin name-ni daxil edin");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("productin productCategory-ni daxil edin");
        Scanner scanner1 = new Scanner(System.in);
        System.out.println(
                        "MEAT_AND_GOURMET yazanda bu catagory olacaq \n" +
                        "DRY_FOOD yazanda bu catagory olacaq ,\n" +
                        "SWEETS   yazanda bu catagory olacaq ,\n" +
                        "DRINKS   yazanda bu catagory olacaq ,\n" +
                        "FRUIT_AND_VEGETABLES yazanda bu catagory olacaq ,\n" +
                        "DAIRY_PRODUCTS yazanda bu catagory olacaq ,\n" +
                        "CLEANİNG_PRODUCTS yazanda bu catagory olacaq ;");
        ProductCategory productCategory = ProductCategory.valueOf(scanner1.nextLine());
        System.out.println("productin price-ni daxil edin");
        Scanner scanner2 = new Scanner(System.in);
        BigDecimal price = scanner2.nextBigDecimal();
        System.out.println("productin count-unu daxil edin");
        Scanner scanner3 = new Scanner(System.in);
        Integer count = scanner3.nextInt();
        Product product = new Product(barcode, name, productCategory, price, count);
        return product;
    }

    public void operateOnProductMenu() {
        Boolean b = true;

        System.out.println(
                "1-i  basanda Yeni mehsul elave edilecek \n" +
                        "2-ni basanda Mehsul uzerinde duzelis edilecek \n" +
                        "3-u  basanda Mehsul silinecek \n" +
                        "4-u  basanda Butun mehsullari gosterilecek \n" +
                        "5-i  basanda Categoriyasina gore mehsullar gosterilecek \n" +
                        "6-ni basanda Qiymet araligina gore mehsullari gosterilecek \n" +
                        "7-ni basanda Mehsullar arasinda ada gore axtaris edilecek \n" +
                        "8 basanda sistemden cixacaq ");

        while (b) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Secmek istediyiniz mehsul operation nomresini daxil edin: ");
            int operation1 = scanner1.nextInt();

            if (operation1 == 1) {
                productImpl.addProduct(addProduct());
                System.out.println("Product was added");
            } else if (operation1 == 2) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("productin barcode-ni daxil edin");
                String barcode = sc1.nextLine();
                productImpl.updateProduct(barcode, addProduct());
                System.out.println("Product was updated");
            } else if (operation1 == 3) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("productin barcode-ni daxil edin");
                String barcode = sc1.nextLine();
                productImpl.deleteProduct(barcode);
                System.out.println("Product was deleted");
            } else if (operation1 == 4) {
                ProductImpl.products.stream().forEach(System.out::println);
            } else if (operation1 == 5) {
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
                        ProductImpl.products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.MEAT_AND_GOURMET)).forEach(System.out::println);
                    } else if (operation2 == 2) {
                        ProductImpl.products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.DRY_FOOD)).forEach(System.out::println);
                    } else if (operation2 == 3) {
                        ProductImpl.products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.SWEETS)).forEach(System.out::println);
                    } else if (operation2 == 4) {
                        ProductImpl.products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.DRINKS)).forEach(System.out::println);
                    } else if (operation2 == 5) {
                        ProductImpl.products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.FRUIT_AND_VEGETABLES)).forEach(System.out::println);
                    } else if (operation2 == 6) {
                        ProductImpl.products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.DAIRY_PRODUCTS)).forEach(System.out::println);
                    } else if (operation2 == 7) {
                        ProductImpl.products.stream().filter(product -> product.getProductCategory().equals(ProductCategory.CLEANİNG_PRODUCTS)).forEach(System.out::println);
                    } else {
                        aBoolean = false;
                    }
                }
            } else if (operation1 == 6) {
                System.out.println("productin firstprice-ni daxil edin");
                Scanner scanner2 = new Scanner(System.in);
                BigDecimal frstprice = scanner2.nextBigDecimal();
                System.out.println("productin endprice-ni daxil edin");
                Scanner scanner3 = new Scanner(System.in);
                BigDecimal endprice = scanner3.nextBigDecimal();
                productImpl.getProductByPrice(frstprice, endprice);
            } else if (operation1 == 7) {
                System.out.println("productin name-ni daxil edin");
                Scanner scanner3 = new Scanner(System.in);
                String name = scanner3.nextLine();
                if (addProduct().getName().equals(name)) {
                    System.out.println(addProduct());
                }
            }else if (operation1 == 8) {
                b=false;
                System.out.println("product menyusundan cixdi");
            }
        }
        }

    public void operateOnSalesMenu() {
        Boolean b = true;

        System.out.println(
                        "1-i  basanda Yeni satis elave edilecek \n" +
                        "2-ni basanda Satisdaki hansisa mehsulun geri qaytarilmasi \n" +
                        "3-u  basanda Satisin silinmesi \n" +
                        "4-u  basanda Butun satislarin ekrana cixarilmasi \n" +
                        "5-i  basanda Verilen tarix araligina gore satislarin gosterilmesi \n" +
                        "6-ni basanda Verilen mebleg araligina gore satislarin gosterilmesi \n" +
                        "7-ni basanda Verilmis bir tarixde olan satislarin gosterilmesi \n" +
                        "8-i  basanda Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi \n" +
                        "9-i  basanda sales sistemden cixacaq ");

        while (b) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Secmek istediyiniz sales operation nomresini daxil edin: ");
            int operation1 = scanner1.nextInt();

            if (operation1 == 1) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("productin barcode-ni daxil edin");
                String barcode = sc1.nextLine();
                Scanner sc2 = new Scanner(System.in);
                System.out.println("productin salesItemCount-ni daxil edin");
                Integer salesItemCount = sc2.nextInt();
                List<SalesItem> salesItems=new ArrayList<>();
                salesItems.add(new SalesItem(barcode,salesItemCount,LocalDateTime.now()));
                salesImpl.addSales(salesItems);
                System.out.println("Sales was added");
            } else if (operation1 == 2) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("productin barcode-ni daxil edin");
                String barcode = sc1.nextLine();
                Scanner sc2 = new Scanner(System.in);
                System.out.println("salesItemCount-ni daxil edin");
                Integer salesItemCount = sc2.nextInt();
                Scanner sc3 = new Scanner(System.in);
                System.out.println("salesNumber-ini daxil edin");
                String salesNumber = sc3.nextLine();
                SalesItem salesItem=new SalesItem(barcode,salesItemCount,LocalDateTime.now());
                salesImpl.returnSalesProduct(salesItem,salesNumber);
                System.out.println("Sale was returned");
            } else if (operation1 == 3) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("sales number-i daxil edin");
                String salesNumber = sc1.nextLine();
                List<SalesItem> salesItems=new ArrayList<>();
                if (SalesImpl.sales.stream().allMatch(sale -> sale.getSalesNumber().equals(salesNumber))){
                    salesImpl.returnAllSales(salesItems);
                }
                System.out.println("All Sales were returned");
            } else if (operation1 == 4) {
                SalesImpl.sales.stream().forEach(System.out::println);
            } else if (operation1 == 5) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("salesin startTime-i daxil edin");
                System.out.println("yyyy,MM,dd,HH,mm formatinda daxil edin");
                LocalDateTime startTime = LocalDateTime.parse(sc1.nextLine());
                Scanner sc2 = new Scanner(System.in);
                System.out.println("salesin endTime-i daxil edin");
                System.out.println("yyyy,MM,dd,HH,mm formatinda daxil edin");
                LocalDateTime endTime = LocalDateTime.parse(sc2.nextLine());
                salesImpl.getBeetweenTwoTime(startTime,endTime);
            } else if (operation1 == 6) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("salesin startPrice-ni daxil edin");
                BigDecimal startPrice = sc1.nextBigDecimal();
                Scanner sc2 = new Scanner(System.in);
                System.out.println("salesin endPrice-ni daxil edin");
                BigDecimal endPrice =sc2.nextBigDecimal();
                salesImpl.getSalesPrice(startPrice,endPrice);
            } else if (operation1 == 7) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("salesin time-ni daxil edin");
                LocalDate time = LocalDate.parse(sc1.nextLine());
                salesImpl.getInOneDaySales(time);
            }else if (operation1 == 8) {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("salesin salesNumber-ini daxil edin");
                String salesNumber = sc1.nextLine();
                if (SalesImpl.sales.stream().allMatch(sale -> sale.getSalesNumber().equals(salesNumber))){
                    SalesImpl.sales.stream().forEach(System.out::println);
                }
            }else if (operation1 == 9) {
                b=false;
                System.out.println("sales menyusundan cixdi");
            }
         }
      }
    }
