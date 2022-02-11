package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Total number of animals " + animals.length);
        makeAnimalsTalk();
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        printAllAnimals(animalArrayList);
        System.out.println("Total number of animals in the arraylist: " + animalArrayList.size());
        animalArrayList.add(new Duck("Duckie"));
        animalArrayList.add(new Duck("Duckieeee"));
        printAllAnimals(animalArrayList);
        System.out.println("Total number of animals in the arraylist: " + animalArrayList.size());

        Duck louie = new Duck("Louie");
        Elephant strongOne = new Elephant("strongOne");
        Parrot andy = new Parrot("andy");

        animalArrayList.add(louie);
        animalArrayList.add(strongOne);
        animalArrayList.add(andy);
        printAllAnimals(animalArrayList);
        System.out.println("Total number of animals in the arraylist: " + animalArrayList.size());

        System.out.println("Position of Louie is : " + (animalArrayList.indexOf(louie)+1));
        System.out.printf("before sorting:");
        printAllAnimals(animalArrayList);
        animalArrayList.sort(Animal.AnimalComparator);
        System.out.printf("after sorting:");
        printAllAnimals(animalArrayList);




    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for(Animal a: animalArrayList) {
            System.out.println(a);
        }
    }
}
