package org.example;

import java.util.Objects;

public class UseServiceObject {
    public static Studentinter getServiceObject(String type){
        if(type.equalsIgnoreCase("database")){
            return new StudentImplDB();
        } else if (type.equalsIgnoreCase("memory")) {
            return new StudentImpl();
        }
        return null;
    }
}
