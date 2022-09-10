package hw13.dao.inter;

import hw13.model.impl.Family;

import java.util.List;
import java.util.Optional;

public interface FamilyDaoInter {
  List<Family> getAllFamilies();
  Optional<Family> getFamilyByIndex(int index);
  boolean deleteFamily(int index);
  boolean deleteFamily(Family f);
  void saveFamily(Family f);
}
