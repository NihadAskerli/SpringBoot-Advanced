package az.company;

import az.company.service.db.ProductDBImpl;
import az.company.service.db.SalesDBImpl;
import az.company.service.impl.ProductImpl;
import az.company.service.impl.SalesImpl;
import az.company.service.inter.ProductInter;
import az.company.service.inter.SalesInter;

public class FactoryPattern {

    public ProductInter getFactory(String type){
        if (type==null){
            return null;
        }if (type.equalsIgnoreCase("list")){
            return new ProductImpl();
        }else if (type.equalsIgnoreCase("db")){
            return new ProductDBImpl();
        }
        return null;
    }

    public SalesInter getFactorySales(String type){
        if (type==null){
            return null;
        }if (type.equalsIgnoreCase("list")){
            return new SalesImpl();
        }else if (type.equalsIgnoreCase("db")){
            return new SalesDBImpl();
        }
        return null;
    }

}
