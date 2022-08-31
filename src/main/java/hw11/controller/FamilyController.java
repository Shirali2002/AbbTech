package hw11.controller;

import hw11.model.impl.Family;
import hw11.model.impl.Man;
import hw11.model.impl.Woman;
import hw11.model.inter.AbstractHuman;
import hw11.model.inter.AbstractPet;
import hw11.service.FamilyService;

import java.util.List;

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

  public void getFamiliesBiggerThan(int countMember) {
    familyService.getFamiliesBiggerThan(countMember);
  }

  public void getFamiliesLessThan(int countMember) {
    familyService.getFamiliesLessThan(countMember);
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
    return familyService.bornChild(family, masculine, feminine);
  }

  public Family adoptChild(Family family, AbstractHuman child) {
    return familyService.adoptChild(family, child);
  }

  public void deleteAllChildrenOlderThan(int age) {
    familyService.deleteAllChildrenOlderThan(age);
  }

  public int count(){
    return familyService.count();
  }

  public Family getFamilyById(int index){
    return familyService.getFamilyById(index);
  }

  public List<AbstractPet> getPets(int familyIndex){
    return familyService.getPets(familyIndex);
  }

  public void addPet(int familyIndex, AbstractPet pet){
    familyService.addPet(familyIndex, pet);
  }
}


