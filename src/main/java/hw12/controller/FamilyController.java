package hw12.controller;

import hw12.exception.FamilyOverflowException;
import hw12.model.impl.Family;
import hw12.model.impl.Man;
import hw12.model.impl.Woman;
import hw12.model.inter.AbstractHuman;
import hw12.model.inter.AbstractPet;
import hw12.service.FamilyService;
import hw12.util.Util;

import java.util.List;
import java.util.Optional;

public class FamilyController {
  private static final FamilyController familyController;
  private final FamilyService familyService = FamilyService.getInstance();

  static {
    familyController = new FamilyController();
  }

  private FamilyController() {
  }

  public static FamilyController getInstance(){
    return familyController;
  }

  public List<Family> getAllFamilies() {
    return familyService.getAllFamilies();
  }

  public void displayAllFamilies() {
    familyService.displayAllFamilies();
  }

  public List<Family> getFamiliesBiggerThan(int countMember) {
    return familyService.getFamiliesBiggerThan(countMember);
  }

  public List<Family> getFamiliesLessThan(int countMember) {
    return familyService.getFamiliesLessThan(countMember);
  }

  public int countFamiliesWithMemberNumber(int countMember) {
    return familyService.countFamiliesWithMemberNumber(countMember);
  }

  public void addFamily(Family family){
    familyService.addFamily(family);
  }

  public void createNewFamily(Man father, Woman mother) {
    familyService.createNewFamily(father, mother);
  }

  public void deleteFamilyByIndex(int index) {
    familyService.deleteFamilyByIndex(index);
  }

  public Family bornChild(Family family, String masculine, String feminine) {
    try {
      Util.checkFamilySize(family);
      return familyService.bornChild(family, masculine, feminine);
    } catch (FamilyOverflowException fex){
      System.out.println("This Family is full.");
      return family;
    }
  }

  public Family adoptChild(Family family, AbstractHuman child) {
    try {
      Util.checkFamilySize(family);
      return familyService.adoptChild(family, child);
    } catch (FamilyOverflowException fex){
      System.out.println("This Family is full.");
      return family;
    }
  }

  public void deleteAllChildrenOlderThan(int age) {
    familyService.deleteAllChildrenOlderThan(age);
  }

  public int count(){
    return familyService.count();
  }

  public Optional<Family> getFamilyById(int index){
    return familyService.getFamilyById(index);
  }


  public List<AbstractPet> getPets(int familyIndex){
    return familyService.getPets(familyIndex);
  }

  public void addPet(int familyIndex, AbstractPet pet){
    familyService.addPet(familyIndex, pet);
  }
}


