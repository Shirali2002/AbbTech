package hw8.abstracts;


import hw8.concretes.Family;
import hw8.enums.Status;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public abstract class AbstractHuman {
    /**
     * FIELDS
     */
    private String name;
    private String surname;
    private Integer year;
    private Integer iq;
    private Family family;
    private String[][] schedule; //[day of the week] x [type of the activity]
    private Status status = Status.NONE;

    /** STATIC BLOCK */
    static {
        System.out.printf("a new class is being loaded(%s).\n", AbstractHuman.class.getName());
    }

    /** INSTANCE BLOCK */ {
        System.out.printf("a new object is created(%s).\n", this.getClass());
    }

    /**
     * CONSTRUCTORS
     */
    public AbstractHuman() {
    }

    public AbstractHuman(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year >= 0 ? year : null;
    }

    public AbstractHuman(String name, String surname, Integer year, Integer iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year >= 0 ? year : null;
        this.iq = iq >= 0 ? iq : null;
        this.schedule = schedule;
    }

    /**
     * GETTERS AND SETTERS
     */
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * BEHAVIOURS
     */
    public abstract void greetPet();

    public void describePet() {
        if (!hasPet()) {
            return;
        }
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                family.getPet().getSpecies(), family.getPet().getAge(), family.getPet().getTrickLevel() <= 50 ? "almost not sly" : "very sly");
    }

    public boolean feedPet(boolean isTimeFeed) {
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

    protected boolean hasPet() {
        return this.family.getPet() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        AbstractHuman human = (AbstractHuman) o;

        if (status == Status.CHILD) {
            return  /** CHILD IDENTIFICATION */
                    Objects.equals(year, human.year) &&
                            Objects.equals(name, human.name) &&
                            Objects.equals(surname, human.surname) &&
                            /** CHILD'S FAMILY IDENTIFICATION */
                            Objects.equals(family.getFather().getName(), human.family.getFather().getName()) &&
                            Objects.equals(family.getFather().getSurname(), human.family.getFather().getSurname()) &&
                            Objects.equals(family.getFather().getYear(), human.family.getFather().getYear()) &&
                            Objects.equals(family.getMother().getName(), human.family.getMother().getName()) &&
                            Objects.equals(family.getMother().getSurname(), human.family.getMother().getSurname()) &&
                            Objects.equals(family.getMother().getYear(), human.family.getMother().getYear());
        } else {
            return  /** HUMAN IDENTIFICATION */
                    Objects.equals(year, human.year) &&
                            Objects.equals(name, human.name) &&
                            Objects.equals(surname, human.surname);
        }


    }

    @Override
    public int hashCode() {
        if (status == Status.CHILD) {
            return Objects.hash(name, surname, year,
                    family.getFather().getName(), family.getFather().getSurname(), family.getFather().getYear(),
                    family.getMother().getName(), family.getMother().getSurname(), family.getMother().getYear());
        } else {
            return Objects.hash(name, surname, year);

        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1)); // get the class name with dynamic form
        stringBuilder.append('{');

        if (name == null) return stringBuilder.append('}').toString();
        else stringBuilder.append("name='").append(name).append('\'');

        if (surname != null) stringBuilder.append(", surname='").append(surname).append('\'');
        if (year != null) stringBuilder.append(", year=").append(year);
        if (iq != null) stringBuilder.append(", iq=").append(iq);
        if (schedule != null) stringBuilder.append(", schedule=").append(Arrays.deepToString(schedule));
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Garbage collector removed %s class's object. The object is %s.\n", this.getClass().getName(), this);
        super.finalize();
    }
}
