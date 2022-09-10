package hw13.dao.impl;

import hw13.dao.inter.FamilyDaoInter;
import hw13.model.impl.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionFamilyDao implements FamilyDaoInter {
  private static final CollectionFamilyDao collectionFamilyDao;
  private List<Family> families;

  private CollectionFamilyDao() {
    families = new ArrayList<>();
  }

  static {
    collectionFamilyDao = new CollectionFamilyDao();
  }

  public static CollectionFamilyDao getInstance() {
    return collectionFamilyDao;
  }

  public void loadAllData(){
    final FileFamilyDao fileFamilyDao = FileFamilyDao.getInstance();
    if (fileFamilyDao.load().isPresent()){
      families = fileFamilyDao.load().get();
    }
  }

  @Override
  public List<Family> getAllFamilies() {
    return collectionFamilyDao.families;
  }

  @Override
  public Optional<Family> getFamilyByIndex(int index) {
    try {
      return Optional.ofNullable(collectionFamilyDao.families.get(index));
    } catch (IndexOutOfBoundsException e) {
      return Optional.empty();
    }
  }

  @Override
  public boolean deleteFamily(int index) {
    try {
      collectionFamilyDao.families.remove(index);
      return true;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  @Override
  public boolean deleteFamily(Family f) {
    return collectionFamilyDao.families.remove(f);
  }

  @Override
  public void saveFamily(Family f) {
    if (!collectionFamilyDao.families.contains(f)){
      collectionFamilyDao.families.add(f);
    }
  }
}
