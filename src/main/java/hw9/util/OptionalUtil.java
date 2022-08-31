package hw9.util;

import hw9.model.impl.Family;

import java.util.Optional;

public class OptionalUtil {
  public static <T> T optionalFamilyCheck(Optional<T> optional){
    return optional.orElse(null);
  }
}
