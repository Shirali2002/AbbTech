package hw11.service;

import hw11.dao.impl.CollectionFamilyDao;
import hw11.dao.inter.FamilyDao;
import hw11.model.impl.Family;
import hw11.model.impl.Man;
import hw11.model.impl.Woman;
import hw11.model.inter.AbstractHuman;
import hw11.model.inter.AbstractPet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FamilyService {
  private static final FamilyService familyService;
  private final FamilyDao familyDao = CollectionFamilyDao.getInstance();

  static {
    familyService = new FamilyService();
  }

  private FamilyService() {
  }

  public static FamilyService getInstance(){
    return familyService;
  }

  public List<Family> getAllFamilies() {
    return familyDao.getAllFamilies();
  }

  public void displayAllFamilies() {
    IntStream.range(0, familyDao.getAllFamilies().size())
        .forEach(
            n -> {
                if (familyDao.getFamilyByIndex(n).isPresent())
                  System.out.printf("%d - %s\n", n, familyDao.getFamilyByIndex(n).get());
            }
        );
  }

  public void getFamiliesBiggerThan(int countMember) {
    familyDao.getAllFamilies().stream()
        .filter(f -> f.countFamily() > countMember)
        .forEach(System.out::println);
  }

  public void getFamiliesLessThan(int countMember) {
    familyDao.getAllFamilies().stream()
        .filter(f -> f.countFamily() < countMember)
        .forEach(System.out::println);
  }

  public int countFamiliesWithMemberNumber(int countMember) {
    return (int) familyDao.getAllFamilies().stream()
        .filter(f -> f.countFamily() == countMember)
        .count();
  }

  public void addFamily(Family family){
    if (familyDao.getAllFamilies().stream().noneMatch(f -> f.equals(family))){
      familyDao.saveFamily(family);
    }
  }

  public void createNewFamily(Man father, Woman mother) {
    Family family = new Family(mother, father);
    if (familyDao.getAllFamilies().stream().noneMatch(f -> f.equals(family))){
      familyDao.saveFamily(family);
    }
  }

  public void deleteFamilyByIndex(int index) {
    familyDao.deleteFamily(index);
  }

  public Family bornChild(Family f, String masculine, String feminine) {
    List<Family> allFamilies = familyDao.getAllFamilies();
    return IntStream.range(0, allFamilies.size())
        .filter(i -> allFamilies.get(i).equals(f))
        .mapToObj(res -> {
              allFamilies.get(res).bornChild(masculine, feminine);
              return allFamilies.get(res);
            }
        )
        .findFirst()
        .orElse(null);
  }

  public Family adoptChild(Family f, AbstractHuman child) {
    List<Family> allFamilies = familyDao.getAllFamilies();
    return IntStream.range(0, allFamilies.size())
        .filter(i -> allFamilies.get(i).equals(f))
        .mapToObj(res -> {
              allFamilies.get(res).addChild(child);
              return allFamilies.get(res);
            }
        )
        .findFirst()
        .orElse(null);
  }

  private int getAgeFromHumanYear(AbstractHuman human){
    return LocalDate.now().getYear() - human.getBirthYear();
  }

  public void deleteAllChildrenOlderThan(int age) {
    List<Family> allFamilies = familyDao.getAllFamilies();
    IntStream.range(0, allFamilies.size())
        .forEach(f -> {
              List<AbstractHuman> children = allFamilies.get(f).getChildren();
              List<AbstractHuman> removeList = IntStream.range(0, allFamilies.get(f).getChildren().size())
                  .filter(index -> getAgeFromHumanYear(children.get(index)) > age)
                  .mapToObj(children::get)
                  .collect(Collectors.toList());
              removeList.forEach(children::remove);
            }
        );
  }


  public int count(){
    return familyDao.getAllFamilies().size();
  }

  public Optional<Family> getFamilyById(int index){
    try {
      return Optional.of(familyDao.getAllFamilies().get(index));
    }catch (IndexOutOfBoundsException ex){
      return Optional.empty();
    }
  }

  public List<AbstractPet> getPets(int familyIndex){
    return new ArrayList<>(familyDao.getAllFamilies()
        .get(familyIndex)
        .getPets());
  }

  public void addPet(int familyIndex, AbstractPet pet){
    familyDao.getAllFamilies()
        .get(familyIndex)
        .addPet(pet);
  }
}
