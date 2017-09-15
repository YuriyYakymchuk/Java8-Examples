package com.yuriy.java8;

import com.yuriy.model.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Examples based on Functional programming in Java 8 book
 *
 * Created by Kucya on 03.09.2017.
 */
public class Java8Examples {

    public static int calculatePersonTotalAge(final Collection<Person> persons, final Predicate<Person> filter) {
        return persons.stream()
                .filter(filter)
                .mapToInt(Person::getAge)
                .sum();
    }

    public static void registerFileChangeListener() throws IOException, InterruptedException {
        final Path path = Paths.get("d:\\Temp\\");
        final WatchService watchService = path.getFileSystem().newWatchService();

        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

        if(watchKey != null) {
            watchKey.pollEvents().stream()
                    .map(WatchEvent::context)
                    .forEach(System.out::println);
        }

        System.out.println(path.toString());
    }

    private static void listFiles() throws IOException {
        Files.newDirectoryStream(
                Paths.get("."), path -> path.toString().endsWith(".xml")).forEach(System.out::println);
        File[] files = new File(".").listFiles(File::isFile);
        for (File file : files) {
            System.out.println(file.getName());
        }
        Stream.of(new File(".").listFiles())
                .flatMap(file -> file.listFiles() != null ? Stream.of(file.listFiles()) : Stream.of(file))
                .collect(Collectors.toList());
    }

    private static void groupCollection(final Collection<Person> persons) {
        final List<Person> olderThan =
                persons.stream()
                        .filter(person -> person.getAge() > 30)
                        .collect(Collectors.toList());

        final Map<Integer, List<Person>> groupedByAge =
                persons.stream()
                        .collect(Collectors.groupingBy(Person::getAge, Collectors.toList()));

        final Map<Integer, List<String>> groupedByAgeNames =
                persons.stream()
                        .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

        final Comparator<Person> ageComparator = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());

        final Map<Character, Optional<Person>> namesGroupedByCharacter =
                persons.stream()
                        .collect(Collectors.groupingBy(person -> person.getName().charAt(0), Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));


        System.out.println(namesGroupedByCharacter);

    }

    private static void collectionManipulation(final Collection<Person> persons) {
        final List<Person> sorted = persons.stream()
                .sorted(Comparator.comparing(Person::getName).reversed().thenComparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println(sorted);
    }

    private static void stringManipulation(final String message, final Collection<String> names) {
        message.chars()
                .mapToObj(value -> Character.valueOf((char)value))
                .forEach(System.out::println);

        final Comparator<String> comparator = String::compareToIgnoreCase;

        List<String> sorted = names.stream()
                .sorted(comparator.thenComparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(sorted);
    }

    private static void collectionTransformation(final Collection<String> collection, final String endLetter) {
        Optional<String> result = collection.stream()
                .filter(name -> name.endsWith(endLetter))
                .findFirst();
        result.ifPresent(s -> s.length());
        System.out.println(result.orElse("Not found"));

        Optional<String> min = collection.stream()
                .min((name1, name2) -> Integer.compare(name1.length(), name2.length()));
        min.ifPresent(System.out::println);
        String minLength = collection.stream()
                .reduce("Default", (name1, name2) -> name1.length() <= name2.length() ? name1 : name2);
        System.out.println(minLength);

        String names = collection.stream()
                .map(String::toLowerCase)
                .collect(Collectors.joining(":"));
        System.out.println(names);
    }

    private static void transformCollection(final Collection<? extends String> collection) {
        final Predicate<String> lengthBiggerTHanTen= name -> name.contains("Y");
        final Function<Integer, Predicate<String>> lengthBigger = length -> name -> name.length() > length;
        final Function<String, Integer> nameLength = name -> name.length();

        collection.stream()
                .map(name -> name.toUpperCase())
                .filter(lengthBigger.apply(5))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void iterateCollection(Collection<String> collection) {
        collection.forEach(name -> {
            name = "I";
            System.out.println(name);
        });
    }

    public static Double calculatedTotalDiscount(final List<Integer> prices, final Integer lowPrice) {
        return prices.stream()
                .filter(price -> price >= lowPrice)
                .map(price -> price * 0.9)
                .reduce(0.0, Double::sum);
    }

}
