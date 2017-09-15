package com.yuriy.java8;

import com.yuriy.model.IntegerHelper;
import com.yuriy.model.Person;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Kucya on 12.09.2017.
 */
public class Java8Main {

    private static Predicate<Person> workingMen = person -> person.getSex() == Person.SEX.MALE && person.getAge() > 18
            && person.getAge() < 60;
    private static Predicate<Person> workingWomen = person -> person.getSex() == Person.SEX.FEMALE && person.getAge() > 18
            && person.getAge() < 55;

    private static Comparator<Person> personComparator = (o1, o2) -> o1.getSex() == o2.getSex() ? o1.getName().compareTo(o2.getName())
            : o1.getSex().compareTo(o2.getSex());

    private static Predicate<Person> workingPeople = workingMen.or(workingWomen);

    public static void main(String[] args) {
        objectExamples();
        collectorsExample();
    }

    private static void collectorsExample() {
        final List<Integer> integers = Arrays.asList(1,2,3,5,6,7,8,9,10,11,12,13,14,15,16);


        final Collector<Integer, AtomicInteger, Integer> intToDouble = Collector.of(
                () -> new AtomicInteger(0),
                (ints, integer) -> ints.getAndSet(ints.get() + integer),
                (integerHelper, integerHelper2) -> {
                    integerHelper.getAndSet(integerHelper.get() + integerHelper2.get());
                    return integerHelper;
                },
                ints -> ints.get()
               );
        final Integer doubleSum = Arrays.asList(1,2,3).stream().collect(intToDouble);

        System.out.println(doubleSum);

        final int sum = integers.stream().collect(Collectors.summingInt((value) -> (value % 2) == 1 ? value : 0));

        final double avg = integers.stream().collect(Collectors.averagingInt(value -> value - 1)).doubleValue();

        final Map<Boolean, List<Integer>> partitionedMap = integers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));

        final Map<Integer, List<Integer>> groupedMap = integers.stream().collect(Collectors.groupingBy(integer -> (integer - 1)/4));


        final List<String> stringList = Arrays.asList("a1","a2", "b3", "a41", "c5");

        final Map<String, String> groupedStringMap = stringList.stream().collect(
                Collectors.groupingBy(

                        (s) -> s.substring(0,1),
                        Collectors.mapping((s) -> s.substring(1,2),
                        Collectors.joining(":"))
                )
        );

        System.out.println(groupedStringMap);
    }

    private static void objectExamples(){
        final List<Person> persons = Arrays.asList(new Person("Yuriy", 28, Person.SEX.MALE), new Person("Oleh", 17, Person.SEX.MALE),
                new Person("Halyna", 31, Person.SEX.FEMALE));

        final List<Person> result = persons.stream().filter(workingPeople).collect(Collectors.toList());

        System.out.println(result);

        final List<Person> sortedPersons = persons.stream().sorted(personComparator).peek(person -> person.setCity("Lviv")).collect(Collectors.toList());

        final Map<Person.SEX, List<String>> groupedPersons = persons.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.mapping(Person::getName, Collectors.toList())));

        System.out.println(groupedPersons);
    }

    private static void arrayExample() {
        final List<String> stringList = Arrays.asList("a1","a2", "a3", "a41", "a5");

        final long a1Count = stringList.stream().filter("a1"::equals).count();

        final String result = stringList.stream().skip(stringList.size() - 1).findAny().orElse("empty");

        List<String> intStream = stringList.stream().flatMap(s -> Arrays.stream(s.split(""))).distinct().peek(String::toUpperCase).collect(Collectors.toList());

        final String a3 = stringList.stream().filter("a3"::equals).findFirst().orElseThrow(() -> new RuntimeException("Hasn't been found"));

        final String third = stringList.stream().sorted(Comparator.naturalOrder()).skip(3).findFirst().get();

        final String[] twoElements = stringList.stream().skip(1).limit(2).toArray(String[]::new);

        System.out.println(twoElements);
    }
}
