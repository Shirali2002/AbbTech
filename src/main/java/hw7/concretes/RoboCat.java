package hw7.concretes;

import hw7.abstracts.AbstractPet;
import hw7.enums.Species;

public class RoboCat extends AbstractPet {

    static {
        System.out.printf("a new class is being loaded(%s).\n", RoboCat.class.getName());
    }

    public RoboCat() {
        super();
    }

    public RoboCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(Species species, String nickname, int age, int trickLevel, String... habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", this.getNickname());
    }

}
