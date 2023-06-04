package org.example;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class UtilFunction{
    private static Supplier<String> supplier=()->"nihad";
    public void declerativPrograming() {
        Supplier<String> personSupplier=() -> "Alma";

        String l="NIhad";
        System.out.println(l.matches("$[1-9]"));
//        List<Person> people = List.of(new Person("Nihad", "Esgerli", 20),
//                new Person("Anar", "Esgerov", 12));
//        Predicate<Person> pers
//        onPredicate = person -> "Nihad".equals(person.getName());
//        people.stream().filter(personPredicate).collect(Collectors.toList()).
//                forEach(System.out::println);
    }
    public static Predicate getPredicate(){
        Predicate<String> predicate=personNumber->personNumber.startsWith("2") && personNumber.length()==2;
        return predicate;
    }
    public static Predicate getTwoPredicate(){
        Predicate<String> predicate=personNumber->personNumber.contains("3") && personNumber.length()==2;
        return predicate;
    }
    public static Consumer getConsurmer() {

//        Consumer<Person> personConsumer = person -> System.out.println(person.getAge() + "person yas");
        Consumer<String>stringConsumer=s -> foo("Nida");
//        stringConsumer.accept("Nihad");

        return stringConsumer;

    }

    public static Function function() {
Function<Integer,Integer> integerIntegerFunction=integer -> integer*4;
        return integerIntegerFunction;
    }
    public static BiFunction biFunction () {
        BiFunction<Integer,Integer,Integer> biFunction=(number1,number2) -> number1*4+number2+3;
        return biFunction;
    }

    public static Function<Integer, Integer> incremenet() {
        Function<Integer, Integer> end = number -> number + 1;
        Function<Integer, Integer> end2 = number -> number * 10;
        Function<Integer, Integer> end3 = end.andThen(end2);
        return end3;
    }
    public static String foo(String name){
        String s=name+"alma";
        System.out.println(name);
        return s;
    }

}
