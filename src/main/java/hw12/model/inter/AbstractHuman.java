package hw12.model.inter;


import hw12.model.enums.DayOfWeek;
import hw12.model.enums.Status;
import hw12.model.impl.Family;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class AbstractHuman {
  private String name;
  private String surname;
  private Long birthDate;
  private Integer iq;
  private Family family;
  private Map<DayOfWeek, String> schedule; //[day of the week] x [type of the activity]
  private Status status = Status.NONE;

  static {
    System.out.printf("a new class is being loaded(%s).\n", AbstractHuman.class.getName());
  }

  {
    System.out.printf("a new object is created(%s).\n", this.getClass());
    schedule = new HashMap<>();
  }

  public AbstractHuman() {
  }

  public AbstractHuman(String name, String surname, String birthDate)  {
    this.name = name;
    this.surname = surname;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.birthDate = dateFormat.parse(birthDate).getTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  public AbstractHuman(String name, String surname, String birthDate,
                       Integer iq)  {
    this.name = name;
    this.surname = surname;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.birthDate = dateFormat.parse(birthDate).getTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    this.iq = iq >= 0 ? iq : null;
  }

  public AbstractHuman(String name, String surname, String birthDate,
                       Integer iq, Map<DayOfWeek, String> schedule)  {
    this.name = name;
    this.surname = surname;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.birthDate = dateFormat.parse(birthDate).getTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    this.iq = iq >= 0 ? iq : null;
    this.schedule = schedule;
  }

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

  public Long getBirthDate() {
    return birthDate;
  }

  public Calendar getBirthDateWithCalendar(){
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(birthDate);
    return calendar;
  }

  public int getBirthYear(){
    return getBirthDateWithCalendar().get(Calendar.YEAR);
  }

  public void setBirthDate(String birthDate) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    this.birthDate = dateFormat.parse(birthDate).getTime();
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

  public Map<DayOfWeek, String> getSchedule() {
    return schedule;
  }

  public void setSchedule(Map<DayOfWeek, String> schedule) {
    this.schedule = schedule;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public abstract void greetPet();

  public void describePet() {
    if (hasNotPet()) {
      return;
    }

    this.family.getPets().forEach(p -> {
      System.out.printf("I have a %s, he is %d years old, he is %s\n",
          p.getSpecies(),
          p.getAge(),
          p.getTrickLevel() <= 50 ? "almost not sly" : "very sly");
    });

  }

  public String describeAge(){
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(birthDate);
    return String.format("%d/%d/%d", calendar.get(Calendar.DAY_OF_MONTH),
        calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.YEAR));
  }


  public boolean feedPet(boolean isTimeFeed) {
    if (hasNotPet()) {
      return false;
    }
    int pseudorandom = new Random().nextInt(99) + 1;
    this.family.getPets().forEach(p -> {
      if (isTimeFeed) {
        System.out.printf("Hm... I will feed %s/\n", p.getNickname());
      } else if (p.getTrickLevel() > pseudorandom) {
        System.out.printf("Hm... I will feed %s/\n", p.getNickname());
      } else {
        System.out.printf("I think %s is not hungry.", p.getNickname());
      }
    });

    return true;
  }

  protected boolean hasNotPet() {
    return this.family.getPets().size() == 0;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (this == o) {
      return true;
    }
    AbstractHuman human = (AbstractHuman) o;

    if (status == Status.CHILD) {
      return  /* CHILD IDENTIFICATION */
          Objects.equals(birthDate, human.birthDate)
              && Objects.equals(name, human.name)
              && Objects.equals(surname, human.surname)
              /* CHILD'S FAMILY IDENTIFICATION */
              && Objects.equals(family.getFather().getName(),
              human.family.getFather().getName())
              && Objects.equals(family.getFather().getSurname(),
              human.family.getFather().getSurname())
              && Objects.equals(family.getFather().getBirthDate(),
              human.family.getFather().getBirthDate())
              && Objects.equals(family.getMother().getName(),
              human.family.getMother().getName())
              && Objects.equals(family.getMother().getSurname(),
              human.family.getMother().getSurname())
              && Objects.equals(family.getMother().getBirthDate(),
              human.family.getMother().getBirthDate());
    } else {
      return  /* HUMAN IDENTIFICATION */
          Objects.equals(birthDate, human.birthDate)
              && Objects.equals(name, human.name)
              && Objects.equals(surname, human.surname);
    }


  }

  @Override
  public int hashCode() {
    if (status == Status.CHILD) {
      AbstractHuman father = family.getFather();
      AbstractHuman mother = family.getMother();
      return Objects.hash(name, surname, birthDate,
          father.getName(), father.getSurname(), father.getBirthDate(),
          mother.getName(), mother.getSurname(), mother.getBirthDate());
    } else {
      return Objects.hash(name, surname, birthDate);

    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1));
    stringBuilder.append('{');

    if (name == null) {
      return stringBuilder.append('}').toString();
    } else {
      stringBuilder.append("name='").append(name).append('\'');
    }

    if (surname != null) {
      stringBuilder.append(", surname='").append(surname).append('\'');
    }
    if (birthDate != null) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      stringBuilder.append(", birthDate=").append(dateFormat.format(new Date()));
    }
    if (iq != null) {
      stringBuilder.append(", iq=").append(iq);
    }
    if (schedule != null) {
      stringBuilder.append(", schedule=").append(schedule);
    }
    stringBuilder.append('}');

    return stringBuilder.toString();
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.printf("Garbage collector removed %s class's object. The object is %s.\n",
        this.getClass().getName(), this);
    super.finalize();
  }
}
