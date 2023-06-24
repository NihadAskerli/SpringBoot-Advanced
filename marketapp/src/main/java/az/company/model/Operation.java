package az.company.model;

import az.company.FactoryPattern;
import az.company.service.db.SalesItemDBImpl;
import az.company.service.impl.SalesImpl;
import az.company.service.inter.ProductInter;
import az.company.service.inter.SalesInter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Operation {

    public void showProductMenu() {
        System.out.println(
                "1-i  basanda Yeni mehsul elave edilecek \n" +
                        "2-ni basanda Mehsul uzerinde duzelis edilecek \n" +
                        "3-u  basanda Mehsul silinecek \n" +
                        "4-u  basanda Butun mehsullari gosterilecek \n" +
                        "5-i  basanda Categoriyasina gore mehsullar gosterilecek \n" +
                        "6-ni basanda Qiymet araligina gore mehsullari gosterilecek \n" +
                        "7-ni basanda Mehsullar arasinda ada gore axtaris edilecek \n" +
                        "8-ni basanda Mehsullar arasinda barcode-ye gore axtaris edilecek \n" +
                        "9 basanda sistemden cixacaq ");
    }

    public void chooseProductOperation(String type) {
        Boolean b = true;
        FactoryPattern factoryPattern = new FactoryPattern();

        while (b) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Secmek istediyiniz mehsul operation nomresini daxil edin: ");
            int operation1 = scanner1.nextInt();

            if (operation1 == 1) {
                addProductMenu(type, factoryPattern);
            } else if (operation1 == 2) {
                updateMenu(type, factoryPattern);
            } else if (operation1 == 3) {
                deleteProductMenu(type, factoryPattern);
            } else if (operation1 == 4) {
                getAllProductsMenu(type, factoryPattern);
            } else if (operation1 == 5) {
                getProductByMenuCategoryMenu(type, factoryPattern);
            } else if (operation1 == 6) {
                getProductByPriceMenu(type, factoryPattern);
            } else if (operation1 == 7) {
                getProductByNameMenu(type, factoryPattern);
            } else if (operation1 == 8) {
                getProductByBarcodMenu(type, factoryPattern);
            } else if (operation1 == 9) {
                b = false;
                System.out.println("product menyusundan cixdi");
            }
        }
    }

    public void showSalesMenu() {
        System.out.println(
                "1-i  basanda Yeni satis elave edilecek \n" +
                        "2-ni basanda Satisdaki hansisa mehsulun geri qaytarilmasi \n" +
                        "3-u  basanda Satisin geri qaytarilmasi \n" +
                        "4-u  basanda Butun satislarin ekrana cixarilmasi \n" +
                        "5-i  basanda Verilen tarix araligina gore satislarin gosterilmesi \n" +
                        "6-ni basanda Verilen mebleg araligina gore satislarin gosterilmesi \n" +
                        "7-ni basanda Verilmis bir tarixde olan satislarin gosterilmesi \n" +
                        "8-i  basanda Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi \n" +
                        "9-u  basanda satis silinecek \n" +
                        "10-u basanda satis update edilecek \n" +
                        "11-i basanda sales sistemden cixacaq ");
    }

    public void chooseSalesOperation(String type) {
        Boolean b = true;
        FactoryPattern factoryPattern = new FactoryPattern();

        while (b) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Secmek istediyiniz sales operation nomresini daxil edin: ");
            int operation1 = scanner1.nextInt();

            if (operation1 == 1) {
                addSalesMenu(type, factoryPattern);
            } else if (operation1 == 2) {
                returnSalesProductMenu(type, factoryPattern);
            } else if (operation1 == 3) {
                returnAllSalesMenu(type, factoryPattern);
            } else if (operation1 == 4) {
                getAllSalesMenu(type, factoryPattern);
            } else if (operation1 == 5) {
                getBeetweenTwoTimeMenu(type, factoryPattern);
            } else if (operation1 == 6) {
                getSalesPriceMenu(type, factoryPattern);
            } else if (operation1 == 7) {//-
                getInOneDaySalesMenu(type, factoryPattern);
            } else if (operation1 == 8) {
                getSalesBySalesNumberMenu(type, factoryPattern);
            } else if (operation1 == 9) {
                deleteSalesMenu(type, factoryPattern);
            } else if (operation1 == 10) {
                updateSalesMenu(type, factoryPattern);
            } else if (operation1 == 11) {
                b = false;
                System.out.println("sales menyusundan cixdi");
            }
        }
    }

    public Product addProduct() {
        System.out.println("product melumatlari");
        Scanner scId = new Scanner(System.in);
        System.out.println("productin id-sini daxil edin");
        Long id = scId.nextLong();
        Scanner sc1 = new Scanner(System.in);
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
        Product product = new Product(id, barcode, name, productCategory, price, count);
        return product;
    }

    public void addProductMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            ProductInter productInterDb = factoryPattern.getFactory("db");
            productInterDb.addProduct(addProduct());
            System.out.println("Product was added");
        } else if (type.equals("list")) {
            ProductInter productInterList = factoryPattern.getFactory("list");
            productInterList.addProduct(addProduct());
            System.out.println("Product was added");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void updateMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            ProductInter productInterDb = factoryPattern.getFactory("db");
            productInterDb.updateProduct(barcode, addProduct());
            System.out.println("Product was updated");
        } else if (type.equals("list")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            ProductInter productInterList = factoryPattern.getFactory("list");
            productInterList.updateProduct(barcode, addProduct());
            System.out.println("Product was updated");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void deleteProductMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            ProductInter productInterDb = factoryPattern.getFactory("db");
            productInterDb.deleteProduct(barcode);
            System.out.println("Product was deleted");
        } else if (type.equals("list")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            ProductInter productInterList = factoryPattern.getFactory("list");
            productInterList.deleteProduct(barcode);
            System.out.println("Product was deleted");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getAllProductsMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            ProductInter productInterDb = factoryPattern.getFactory("db");
            System.out.println(productInterDb.getAllProducts());
            System.out.println("All the products were brought");
        } else if (type.equals("list")) {
            ProductInter productInterList = factoryPattern.getFactory("list");
            System.out.println(productInterList.getAllProducts());
            System.out.println("All the products were brought");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getProductByMenuCategoryMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            ProductInter productInterDb = factoryPattern.getFactory("db");
            productInterDb.getProductByMenuCategory();
            System.out.println("Products were printed by category");
        } else if (type.equals("list")) {
            ProductInter productInterList = factoryPattern.getFactory("list");
            productInterList.getProductByMenuCategory();
            System.out.println("Products were printed by category");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getProductByPriceMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            System.out.println("productin firstprice-ni daxil edin");
            Scanner scanner2 = new Scanner(System.in);
            BigDecimal frstprice = scanner2.nextBigDecimal();
            System.out.println("productin endprice-ni daxil edin");
            Scanner scanner3 = new Scanner(System.in);
            BigDecimal endprice = scanner3.nextBigDecimal();
            ProductInter productInterDb = factoryPattern.getFactory("db");
            System.out.println(productInterDb.getProductByPrice(frstprice, endprice));
            System.out.println("Products within the included price range have been delivered");
        } else if (type.equals("list")) {
            System.out.println("productin firstprice-ni daxil edin");
            Scanner scanner2 = new Scanner(System.in);
            BigDecimal frstprice = scanner2.nextBigDecimal();
            System.out.println("productin endprice-ni daxil edin");
            Scanner scanner3 = new Scanner(System.in);
            BigDecimal endprice = scanner3.nextBigDecimal();
            ProductInter productInterList = factoryPattern.getFactory("list");
            System.out.println(productInterList.getProductByPrice(frstprice, endprice));
            System.out.println("Products within the included price range have been delivered");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getProductByNameMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            System.out.println("productin name-ni daxil edin");
            Scanner scanner2 = new Scanner(System.in);
            String name = scanner2.nextLine();
            ProductInter productInterDb = factoryPattern.getFactory("db");
            System.out.println(productInterDb.getProductByName(name));
            System.out.println("Product was brought according to the name");
        } else if (type.equals("list")) {
            System.out.println("productin name-ni daxil edin");
            Scanner scanner2 = new Scanner(System.in);
            String name = scanner2.nextLine();
            ProductInter productInterList = factoryPattern.getFactory("list");
            System.out.println(productInterList.getProductByName(name));
            System.out.println("Product was brought according to the name");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getProductByBarcodMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            System.out.println("productin barcode-ni daxil edin");
            Scanner scanner2 = new Scanner(System.in);
            String barcode = scanner2.nextLine();
            ProductInter productInterDb = factoryPattern.getFactory("db");
            System.out.println(productInterDb.getProductByBarcode(barcode));
            System.out.println("Product was brought according to the barcode");
        } else if (type.equals("list")) {
            System.out.println("productin barcode-ni daxil edin");
            Scanner scanner2 = new Scanner(System.in);
            String barcode = scanner2.nextLine();
            ProductInter productInterList = factoryPattern.getFactory("list");
            System.out.println(productInterList.getProductByBarcode(barcode));
            System.out.println("Product was brought according to the barcode");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }

    }

    public void addSalesMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner scId = new Scanner(System.in);
            System.out.println("salesItemin id-sini daxil edin");
            Long id = scId.nextLong();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("productin salesItemCount-ni daxil edin");
            Integer salesItemCount = sc2.nextInt();
            List<SalesItem> salesItems = new ArrayList<>();
            salesItems.add(new SalesItem(id, barcode, salesItemCount, LocalDateTime.now(), null));
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            salesInterDb.addSales(salesItems);
            System.out.println("Sales was added");
        } else if (type.equals("list")) {
            Scanner scId = new Scanner(System.in);
            System.out.println("salesItemin id-sini daxil edin");
            Long id = scId.nextLong();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("productin salesItemCount-ni daxil edin");
            Integer salesItemCount = sc2.nextInt();
            List<SalesItem> salesItems = new ArrayList<>();
            salesItems.add(new SalesItem(id, barcode, salesItemCount, LocalDateTime.now(), null));
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            salesInterList.addSales(salesItems);
            System.out.println("Sales was added");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }

    }

    public void returnSalesProductMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner scId = new Scanner(System.in);
            System.out.println("salesItemin id-sini daxil edin");
            Long id = scId.nextLong();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("productin salesItemCount-ni daxil edin");
            Integer salesItemCount = sc2.nextInt();
            Scanner sc3 = new Scanner(System.in);
            System.out.println("salesNumber-ini daxil edin");
            String salesNumber = sc3.nextLine();
            SalesItem salesItem = new SalesItem(id, barcode, salesItemCount, LocalDateTime.now(), null);
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            salesInterDb.returnSalesProduct(salesItem, salesNumber);
            System.out.println("Sales was returned");
        } else if (type.equals("list")) {
            Scanner scId = new Scanner(System.in);
            System.out.println("salesItemin id-sini daxil edin");
            Long id = scId.nextLong();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("productin salesItemCount-ni daxil edin");
            Integer salesItemCount = sc2.nextInt();
            Scanner sc3 = new Scanner(System.in);
            System.out.println("salesNumber-ini daxil edin");
            String salesNumber = sc3.nextLine();
            SalesItem salesItem = new SalesItem(id, barcode, salesItemCount, LocalDateTime.now(), null);
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            salesInterList.returnSalesProduct(salesItem, salesNumber);
            System.out.println("Sales was returned");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }

    }

    public void returnAllSalesMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("sales number-i daxil edin");
            String salesNumber = sc1.nextLine();
            List<SalesItem> salesItems = new SalesItemDBImpl().getSalesItemsBysalesNumber(salesNumber);
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            Sale sale = salesInterDb.getSalesBySalesNumber(salesNumber);
            if (sale.getSalesNumber().equals(salesNumber)) {
                salesInterDb.returnAllSales(salesItems);
            }else {
                System.out.println("bele satis yoxdu");
            }
            System.out.println("All Sales were returned");
        } else if (type.equals("list")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("sales number-i daxil edin");
            String salesNumber = sc1.nextLine();
            List<SalesItem> salesItems = new ArrayList<>();
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            if (SalesImpl.sales.stream().allMatch(sale -> sale.getSalesNumber().equals(salesNumber))) {
                salesInterList.returnAllSales(salesItems);
                System.out.println("All Sales was returned");
            }
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }

    }

    public void getAllSalesMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            List<Sale> sales = salesInterDb.getAllSales();
            System.out.println(sales);
            System.out.println("All Sales showed");
        } else if (type.equals("list")) {
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            System.out.println(salesInterList.getAllSales());
            System.out.println("All Sales showed");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }

    }

    public void getBeetweenTwoTimeMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("salesin baslangic il-ini daxil edin");
            int year = sc2.nextInt();
            Scanner sc3 = new Scanner(System.in);
            System.out.println("salesin baslangic ay-ini daxil edin");
            int month = sc3.nextInt();
            Scanner sc4 = new Scanner(System.in);
            System.out.println("salesin baslangic gun-unu daxil edin");
            int day = sc4.nextInt();
            Scanner sc5 = new Scanner(System.in);
            System.out.println("salesin baslangic saat-ini daxil edin");
            int hour = sc5.nextInt();
            Scanner sc6 = new Scanner(System.in);
            System.out.println("salesin baslangic deqiqe-sini daxil edin");
            int minute = sc6.nextInt();
            LocalDateTime startTime=LocalDateTime.of(year,month,day,hour,minute);

            Scanner sc7 = new Scanner(System.in);
            System.out.println("salesin bitmek il-ini daxil edin");
            int year1 = sc7.nextInt();
            Scanner sc8 = new Scanner(System.in);
            System.out.println("salesin bitmek ay-ini daxil edin");
            int month1 = sc8.nextInt();
            Scanner sc9= new Scanner(System.in);
            System.out.println("salesin bitmek gun-unu daxil edin");
            int day1 = sc9.nextInt();
            Scanner sc10 = new Scanner(System.in);
            System.out.println("salesin bitmek saat-ini daxil edin");
            int hour1 = sc10.nextInt();
            Scanner sc11 = new Scanner(System.in);
            System.out.println("salesin bitmek deqiqe-sini daxil edin");
            int minute1 = sc11.nextInt();
            LocalDateTime endTime=LocalDateTime.of(year1,month1,day1,hour1,minute1);

            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            System.out.println(salesInterDb.getBeetweenTwoTime(startTime, endTime));
            System.out.println("the sale between the dates was brought");
        } else if (type.equals("list")) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("salesin il-ini daxil edin");
            int year = sc2.nextInt();
            Scanner sc3 = new Scanner(System.in);
            System.out.println("salesin ay-ini daxil edin");
            int month = sc3.nextInt();
            Scanner sc4 = new Scanner(System.in);
            System.out.println("salesin gun-unu daxil edin");
            int day = sc4.nextInt();
            Scanner sc5 = new Scanner(System.in);
            System.out.println("salesin saat-ini daxil edin");
            int hour = sc5.nextInt();
            Scanner sc6 = new Scanner(System.in);
            System.out.println("salesin deqiqe-sini daxil edin");
            int minute = sc6.nextInt();
            LocalDateTime startTime=LocalDateTime.of(year,month,day,hour,minute);

            Scanner sc7 = new Scanner(System.in);
            System.out.println("salesin il-ini daxil edin");
            int year1 = sc7.nextInt();
            Scanner sc8 = new Scanner(System.in);
            System.out.println("salesin ay-ini daxil edin");
            int month1 = sc8.nextInt();
            Scanner sc9= new Scanner(System.in);
            System.out.println("salesin gun-unu daxil edin");
            int day1 = sc9.nextInt();
            Scanner sc10 = new Scanner(System.in);
            System.out.println("salesin saat-ini daxil edin");
            int hour1 = sc10.nextInt();
            Scanner sc11 = new Scanner(System.in);
            System.out.println("salesin deqiqe-sini daxil edin");
            int minute1 = sc11.nextInt();
            LocalDateTime endTime=LocalDateTime.of(year1,month1,day1,hour1,minute1);

            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            System.out.println("Among two the time sales " + salesInterList.getBeetweenTwoTime(startTime, endTime));
            System.out.println("the sale between the dates was brought");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getSalesPriceMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("salesin startPrice-ni daxil edin");
            BigDecimal startPrice = sc1.nextBigDecimal();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("salesin endPrice-ni daxil edin");
            BigDecimal endPrice = sc2.nextBigDecimal();
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            System.out.println("Among two the time sales " + salesInterDb.getSalesPrice(startPrice, endPrice));
            System.out.println("the sale between the price was brought");
        } else if (type.equals("list")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("salesin startPrice-ni daxil edin");
            BigDecimal startPrice = sc1.nextBigDecimal();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("salesin endPrice-ni daxil edin");
            BigDecimal endPrice = sc2.nextBigDecimal();
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            System.out.println("Among two the time sales " + salesInterList.getSalesPrice(startPrice, endPrice));
            System.out.println("the sale between the price was brought");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getInOneDaySalesMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("salesin il-ini daxil edin");
            int year = sc2.nextInt();
            Scanner sc3 = new Scanner(System.in);
            System.out.println("salesin ay-ini daxil edin");
            int month = sc3.nextInt();
            Scanner sc4 = new Scanner(System.in);
            System.out.println("salesin gun-unu daxil edin");
            int day = sc4.nextInt();
            LocalDate dateTime=LocalDate.of(year,month,day);
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            System.out.println(salesInterDb.getInOneDaySales(dateTime));
            System.out.println("The sales of one day were brought");
        } else if (type.equals("list")) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("salesin il-ini daxil edin");
            int year = sc2.nextInt();
            Scanner sc3 = new Scanner(System.in);
            System.out.println("salesin ay-ini daxil edin");
            int month = sc3.nextInt();
            Scanner sc4 = new Scanner(System.in);
            System.out.println("salesin gun-unu daxil edin");
            int day = sc4.nextInt();
            Scanner sc5 = new Scanner(System.in);
            System.out.println("salesin saat-ini daxil edin");
            int hour = sc5.nextInt();
            Scanner sc6 = new Scanner(System.in);
            System.out.println("salesin deqiqe-sini daxil edin");
            int minute = sc6.nextInt();
            LocalDate dateTime=LocalDate.of(year,month,day);
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            salesInterList.getInOneDaySales(dateTime);
            System.out.println("The sales of one day were brought");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void getSalesBySalesNumberMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("salesin salesNumber-ini daxil edin");
            String salesNumber = sc1.nextLine();
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            System.out.println(salesInterDb.getSalesBySalesNumber(salesNumber));
            System.out.println("The sales were brought according to salesNumber");
        } else if (type.equals("list")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("salesin salesNumber-ini daxil edin");
            String salesNumber = sc1.nextLine();
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            System.out.println(salesInterList.getSalesBySalesNumber(salesNumber));
            System.out.println("The sales were brought according to salesNumber");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }

    public void deleteSalesMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("salesin salesNumber-ini daxil edin");
            String salesNumber = sc1.nextLine();
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            salesInterDb.deleteSales(salesNumber);
            System.out.println("The sales were deleted");
        } else if (type.equals("list")) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("salesin salesNumber-ini daxil edin");
            String salesNumber = sc1.nextLine();
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            salesInterList.deleteSales(salesNumber);
            System.out.println("The sales were deleted");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }

    }

    public void updateSalesMenu(String type, FactoryPattern factoryPattern) {
        if (type.equals("db")) {
            Scanner scId = new Scanner(System.in);
            System.out.println("salesItemin id-sini daxil edin");
            Long id = scId.nextLong();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("productin salesItemCount-unu daxil edin");
            Integer salesItemCount = sc2.nextInt();
            List<SalesItem> salesItems = new ArrayList<>();
            salesItems.add(new SalesItem(id, barcode, salesItemCount, LocalDateTime.now(), null));
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("sales price-i daxil edin");
            BigDecimal salesPrice = scanner5.nextBigDecimal();
            Sale sale = new Sale(null, UUID.randomUUID().toString(), salesPrice, salesItems, LocalDateTime.now());
            Scanner scanner = new Scanner(System.in);
            System.out.println("salesin salesNumber-ini daxil edin");
            String salesNumber = scanner.nextLine();
            SalesInter salesInterDb = factoryPattern.getFactorySales("db");
            salesInterDb.updateSales(salesNumber, sale);
            System.out.println("The sales was updated");
        } else if (type.equals("list")) {
            Scanner scId = new Scanner(System.in);
            System.out.println("salesItemin id-sini daxil edin");
            Long id = scId.nextLong();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("productin barcode-ni daxil edin");
            String barcode = sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
            System.out.println("productin salesItemCount-unu daxil edin");
            Integer salesItemCount = sc2.nextInt();
            List<SalesItem> salesItems = new ArrayList<>();
            salesItems.add(new SalesItem(id, barcode, salesItemCount, LocalDateTime.now(), null));
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("sales price-i daxil edin");
            BigDecimal salesPrice = scanner5.nextBigDecimal();
            Sale sale = new Sale(null, UUID.randomUUID().toString(), salesPrice, salesItems, LocalDateTime.now());
            Scanner scanner = new Scanner(System.in);
            System.out.println("salesin salesNumber-ini daxil edin");
            String salesNumber = scanner.nextLine();
            SalesInter salesInterList = factoryPattern.getFactorySales("list");
            salesInterList.updateSales(salesNumber, sale);
            System.out.println("The sales was updated");
        } else {
            System.out.println("Type duzgun daxil edilmeyib! Duzgun daxil edilme: list ve ya db ");
        }
    }
}
