package hw11.util;

import java.util.Optional;

public class OptionalUtil {
  public static <T> T optionalFamilyCheck(Optional<T> optional){
    return optional.orElse(null);
  }
}
