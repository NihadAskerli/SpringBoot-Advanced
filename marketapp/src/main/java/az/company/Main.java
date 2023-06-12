package az.company;

import az.company.model.Menu;
import az.company.service.impl.ProductImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductImpl productImpl=new ProductImpl();
//        productImpl.addProduct(new Product("addd","Duyu",ProductCategory.DRY_FOOD,BigDecimal.valueOf(2),10));
//
        Boolean b = true;
        Menu menu = new Menu();

        System.out.println(
                        "1-i basanda Mehsullar uzerinde emeliyyat aparilacaq \n" +
                        "2-ni basanda Satislar uzerinde emeliyyat aparilacaq \n" +
                        "3-u basanda Sistemden cixilacaq");

        while (b) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Secmek istediyiniz operation nomresini daxil edin: ");
            int operation = scanner.nextInt();

            if (operation == 1) {
                menu.operateOnProductMenu();
            } else if (operation == 2) {
                menu.operateOnSalesMenu();
            } else if (operation == 3) {
                b = false;
                System.out.println("Sistemden chixildi");
            }
        }
    }
}
