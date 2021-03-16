package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog d : dogs) {
            d.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog d : dogs) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        throw new IllegalArgumentException("No result");
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> names = new ArrayList<>();

        for (Dog d : dogs) {
            if (d.getHappiness() > minHappiness) {
                names.add(d.getName());
            }
        }

        return names;
    }
}
