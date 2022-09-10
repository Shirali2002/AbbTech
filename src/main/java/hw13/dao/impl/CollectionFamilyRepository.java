package hw13.dao.impl;

import hw13.controller.LogController;
import hw13.dao.inter.FamilyDaoInter;
import hw13.model.impl.Family;
import hw13.service.LogService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionFamilyRepository implements FamilyDaoInter {
  private static final CollectionFamilyRepository collectionFamilyRepository;
  private final LogController logger = LogController.getInstance();
  private List<Family> families;

  private CollectionFamilyRepository() {
    families = new ArrayList<>();
  }

  static {
    collectionFamilyRepository = new CollectionFamilyRepository();
  }

  public static CollectionFamilyRepository getInstance() {
    return collectionFamilyRepository;
  }

  public void loadAllData(){
    final FileFamilyRepository fileFamilyRepository = FileFamilyRepository.getInstance();
    if (fileFamilyRepository.load().isPresent()){
      families = fileFamilyRepository.load().get();
    }
  }

  @Override
  public List<Family> getAllFamilies() {
    logger.info("get all Families");
    return collectionFamilyRepository.families;
  }

  @Override
  public Optional<Family> getFamilyByIndex(int index) {
    try {
      logger.info(String.format("get %d indexed family.", index));
      return Optional.ofNullable(collectionFamilyRepository.families.get(index));
    } catch (IndexOutOfBoundsException e) {
      logger.error("IndexOutOfBoundsException exception in getFamilyByIndex");
      return Optional.empty();
    }
  }

  @Override
  public boolean deleteFamily(int index) {
    try {
      collectionFamilyRepository.families.remove(index);
      logger.info(String.format("delete %d indexed family.", index));
      return true;
    } catch (IndexOutOfBoundsException e) {
      logger.error("IndexOutOfBoundsException exception in deleteFamily");
      return false;
    }
  }

  @Override
  public boolean deleteFamily(Family f) {
    logger.info(String.format("delete %d indexed family.", getAllFamilies().indexOf(f)));
    return collectionFamilyRepository.families.remove(f);
  }

  @Override
  public void saveFamily(Family f) {
    if (!collectionFamilyRepository.families.contains(f)){
      logger.info("saved family.");
      collectionFamilyRepository.families.add(f);
    }
  }
}
