package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {

    private String name;

    private int happiness;

    public Dog(String name) {
        this.name = name;
        happiness = 0;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHappiness(int happiness) {
        this.happiness += happiness;
    }

    public abstract void feed();

    public abstract void play(int hours);
}
