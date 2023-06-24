package az.company;

import az.company.model.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        PersistenceConfig.entityManager();




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
                menu.operateOnProductMenu(args[0]);
            } else if (operation == 2) {
                menu.operateOnSalesMenu(args[0]);
            } else if (operation == 3) {
                b = false;
                System.out.println("Sistemden chixildi");
            }
        }


    }
}
