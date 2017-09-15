package com.yuriy.serialization;

import com.yuriy.model.Person;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Kucya on 11.09.2017.
 */
public class SerializationMain {

    private static final PersonService personService = new PersonService();

    private static String fileName = "c:\\Temp\\Yuriy";

    public static void main(String[] args) {
       // Person person = new Person("Yuriy", 23, Person.SEX.MALE);

      //  personService.serializePerson(person, );

        Person person = personService.deserializePerson(s -> {
                final FileInputStream fileInputStream = new FileInputStream(s);
                final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return (Person) objectInputStream.readObject();
           }, fileName);

        System.out.println(person);
    }
}
