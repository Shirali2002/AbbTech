package hw13.dao.inter;

import hw13.model.enums.Log;

public interface LogDaoInter {
  boolean save(String message, Log log);
}
