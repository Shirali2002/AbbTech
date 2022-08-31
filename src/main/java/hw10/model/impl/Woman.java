package hw10.model.impl;

import hw10.model.inter.AbstractHuman;
import hw10.model.enums.DayOfWeek;
import java.util.Map;

public class Woman extends AbstractHuman {

    public Woman() {
    }

    public Woman(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, String birthDate, Integer iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, String birthDate, Integer iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    @Override
    public void greetPet() {
        if (super.hasNotPet()){
            return;
        }
        super.getFamily().getPets().forEach(p -> System.out.printf("Hello, %s\n", p.getNickname()));
    }

    public void makeUp(){
        System.out.println("I am doing makeup.");
    }
}
