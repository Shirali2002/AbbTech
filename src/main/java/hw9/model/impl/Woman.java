package hw9.model.impl;

import hw9.model.inter.AbstractHuman;
import hw9.model.enums.DayOfWeek;

import java.util.Map;

public class Woman extends AbstractHuman {

    public Woman() {
    }

    public Woman(String name, String surname, Integer year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, Integer year, Integer iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (super.hasNotPet())    return;
        super.getFamily().getPets().forEach(p -> System.out.printf("Hello, %s\n", p.getNickname()));
    }

    public void makeUp(){
        System.out.println("I am doing makeup.");
    }
}
