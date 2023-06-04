package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test implements Comparator<Test> {
    public String test;
    public int a;
    public int[] arr;
    @Override
    public int compare(Test o1, Test o2) {
        o1.getTest().contains(o2.getTest());
//        if(o1.getTest().equals(o2.getTest()))
        return o1.getA()-o2.getA();
    }
}
