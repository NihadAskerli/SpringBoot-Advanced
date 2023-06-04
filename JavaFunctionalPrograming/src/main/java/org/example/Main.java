package org.example;

import lombok.Data;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public Pattern pattern = Pattern.compile("$[1-9]");
    public static List<Person> people = List.of(
            new Person("Niha", "Esgerli", 20),

            new Person("Niko", "Esgerli", 20),

            new Person("Xeyal1", "Esgerli", 27),

            new Person("Gulsad", "Esgerli", 25),
            new Person("Aynur1", "Esgerli     ", 20));

    public static void main(String[] args) {
//        Predicate<Person>personPredicate=person -> person.getName().equals("Nihad");
//Supplier<NoSuchElementException> supplier=() ->  new NoSuchElementException("bele bir data yoxdur");
//Person person=people.stream().filter(personPredicate).findAny().orElseThrow(supplier);
////people.stream().map().forEach(System.out::println);
//people.stream().flatMap(person -> Stream.of(person.getName().charAt(3))).forEach(System.out::println);
////people.stream().map(person -> pe)
//        BiFunction<Person,Person,Person> personPersonPersonBiFunction=(person, person2) -> person=person2;


    }
public static Function getFullName(Person person1){
    Function<Person,String> personStringFunction=person -> person.getName()+" "+person.getSurname();
       return personStringFunction;

}
    public static void getOptinal() {
        Optional.ofNullable(null).ifPresentOrElse(
                email -> System.out.println("hellodu qardas"),
                () -> {
                    System.out.println("geldim e gledim");
                });


    }

    public static void getStream() {
        Predicate<Person> personPredicate = person -> person.getName().equals("Nihad");
        boolean b = people.stream().anyMatch(personPredicate);
//        List<Person> personList=people.stream().filter(personPredicate).collect(Collectors.toList());
        System.out.println(b);
        Function<Person, String> personStringFunction = person -> person.getName();
        ToIntFunction<String> integerToIntFunction = String::length;
        IntConsumer intConsumer = System.out::println;
        people.stream().map(personStringFunction)
                .mapToInt(integerToIntFunction)
                .forEach(intConsumer);
    }
}