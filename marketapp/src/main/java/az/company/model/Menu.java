package az.company.model;

public class Menu {
    Operation operation=new Operation();
    public void operateOnProductMenu(String type) {
       operation.showProductMenu();
       operation.chooseProductOperation(type);
    }

    public void operateOnSalesMenu(String type) {
        operation.showSalesMenu();
        operation.chooseSalesOperation(type);
    }
}
