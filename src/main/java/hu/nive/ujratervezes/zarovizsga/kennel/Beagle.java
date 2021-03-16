package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        setHappiness(2);
    }

    @Override
    public void play(int hours) {
        setHappiness(hours * 2);
    }
}
