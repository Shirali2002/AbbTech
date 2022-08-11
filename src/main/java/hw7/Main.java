package hw7;

import hw7.abstracts.AbstractPet;
import hw7.concretes.Family;
import hw7.concretes.Man;
import hw7.concretes.Woman;
import hw7.enums.DayOfWeek;
import hw7.enums.Species;
import hw7.concretes.Dog;


class Main {
    public static void main(String[] args) {
        Dog pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");
        System.out.println(pet1);
    }

}
