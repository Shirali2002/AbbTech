package hw5;


import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

class Human {
    /** FIELDS */
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private String[][] schedule; //[day of the week] x [type of the activity]

    /** STATIC BLOCK */
    static {
        System.out.printf("a new class is being loaded(%s).\n", Human.class.getName());
    }

    /** INSTANCE BLOCK */
    {
        System.out.printf("a new object is created(%s).\n", this.getClass());
    }

    /** CONSTRUCTORS */
    Human() {
    }

    Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, int year, int iq, Family family, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.family = family;
        this.schedule = schedule;
    }

    /** GETTERS AND SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    /** BEHAVIOURS */
    void greetPet() {
        if (!hasPet()) {
            return;
        }

        System.out.printf("Hello, %s\n", family.getPet().getNickname());

    }

    void describePet() {
        if (!hasPet()) {
            return;
        }
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                family.getPet().getSpecies(), family.getPet().getAge(), family.getPet().getTrickLevel() <= 50 ? "almost not sly" : "very sly");
    }

    boolean feedPet(boolean isTimeFeed) {
        if (!hasPet()) {
            return false;
        }

        boolean result = false;

        if (isTimeFeed) {
            result = true;
        } else {
            int pseudorandom = new Random().nextInt(99) + 1;
            if (this.family.getPet().getTrickLevel() > pseudorandom) result = true;
        }

        if (result) System.out.printf("Hm... I will feed Jack's %s/\n", this.family.getPet().getNickname());
        else System.out.println("I think Jack is not hungry.");

        return result;

    }

    private boolean hasPet() {
        return this.family.getPet() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Human human = (Human) o;


        return  /** HUMAN IDENTIFICATION */
                year == human.year &&
                name.equals(human.name) &&
                surname.equals(human.surname) &&
                /** HUMAN'S FAMILY IDENTIFICATION */
                family.getFather().getName().equals(human.family.getFather().getName()) &&
                family.getFather().getSurname().equals(human.family.getFather().getSurname()) &&
                family.getFather().getYear() == human.family.getFather().getYear() &&
                family.getMother().getName().equals(human.family.getMother().getName()) &&
                family.getMother().getSurname().equals(human.family.getMother().getSurname()) &&
                family.getMother().getYear() == human.family.getMother().getYear();

    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }

    @Override
    public String toString() {
        if (name == null) {
            return "";
        }
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }


}
