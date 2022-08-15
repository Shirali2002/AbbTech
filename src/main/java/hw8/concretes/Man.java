package hw8.concretes;

import hw8.abstracts.AbstractHuman;

public class Man extends AbstractHuman {

    public Man() {
    }

    public Man(String name, String surname, Integer year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, Integer year, Integer iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (!super.hasPet()) {
            return;
        }
        System.out.printf("Hello, %s\n", super.getFamily().getPet().getNickname());
    }

    public void repairCar(){
        System.out.println("I am repairing car.");
    }
}
