package org.example;

import java.util.ArrayList;
import java.util.List;


abstract class Pet {

    String name;
    int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void makeSound();

    @Override
    public String toString() {
        return "שם: " + name + "\n" +
                "גיל: " + age;
    }
}

class Dog extends Pet {

    String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "גזע: " + breed;
    }
}

class Cat extends Pet {

    String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "צבע: " + color;
    }
}

interface Owner {

    String getName();

    void addPet(Pet pet);

    List<Pet> getPets();

}

class PersonOwner implements Owner {

    private String name;
    private List<Pet> pets = new ArrayList<>();

    public PersonOwner(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public List<Pet> getPets() {
        return pets;
    }
}

public class PetDemo {

    public static void main(String[] args) {

        Dog dog = new Dog("כתם", 5, "לברדור");
        Cat cat = new Cat("מיצי", 3, "שחור");

        PersonOwner owner = new PersonOwner("דוד");
        PersonOwner owner2 = new PersonOwner("יעל");

        List<PersonOwner> owners = new ArrayList<>();
        owners.add(owner);
        owners.add(owner2);

        owner.addPet(dog);
        owner2.addPet(cat);


        for (PersonOwner o : owners) {
            System.out.println("בעלים: " + o.getName());
            for (Pet pet : o.getPets()) {
                System.out.println(pet);
                pet.makeSound();
                System.out.println("-------------------");
            }
        }
    }
}

