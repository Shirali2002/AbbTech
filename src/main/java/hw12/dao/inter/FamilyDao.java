package hw12.dao.inter;

import hw12.model.impl.Family;

import java.util.List;
import java.util.Optional;

public interface FamilyDao {
  List<Family> getAllFamilies();
  Optional<Family> getFamilyByIndex(int index);
  boolean deleteFamily(int index);
  boolean deleteFamily(Family f);
  void saveFamily(Family f);
}
