package hw13.exception;

public class FamilyOverflowException extends RuntimeException{
  public FamilyOverflowException() {
  }

  public FamilyOverflowException(String message) {
    super(message);
  }
}
