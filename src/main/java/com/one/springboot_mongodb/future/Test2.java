package com.one.springboot_mongodb.future;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

public class Test2 {
    public static void main(String[] args) {
        Person person = new Person("htu","hangzhou");
        Person person1 = new Person("zhuyi","guangzhou");

        String initialReference = "initial value referenced";

        AtomicReference<Person> atomicStringReference =
                new AtomicReference<Person>(person);

        String newReference = "new value referenced";
        boolean exchanged = atomicStringReference.compareAndSet(person, person1);
        System.out.println("exchanged: " + exchanged);

        exchanged = atomicStringReference.compareAndSet(person1, person1);
        System.out.println("exchanged: " + exchanged);

    }
}
@AllArgsConstructor
class Person{
    String name;
    String address;
}
