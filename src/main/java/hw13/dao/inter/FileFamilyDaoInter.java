package hw13.dao.inter;

import hw13.model.impl.Family;

import java.util.List;
import java.util.Optional;

public interface FileFamilyDaoInter {
  boolean save(List<Family> fs);
  Optional<List<Family>> load();
}
