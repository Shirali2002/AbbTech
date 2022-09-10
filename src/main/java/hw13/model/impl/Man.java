package hw13.model.impl;

import hw13.model.enums.DayOfWeek;
import hw13.model.inter.AbstractHuman;

import java.util.Map;

public class Man extends AbstractHuman {

    public Man() {
    }

    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, String birthDate, Integer iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, String birthDate, Integer iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (super.hasNotPet())    return;
        super.getFamily().getPets().forEach(p -> System.out.printf("Hello, %s\n", p.getNickname()));
    }

    public void repairCar(){
        System.out.println("I am repairing car.");
    }
}
