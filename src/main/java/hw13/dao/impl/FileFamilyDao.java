package hw13.dao.impl;

import hw13.model.impl.Family;
import hw13.util.Util;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class FileFamilyDao implements hw13.dao.inter.FileFamilyDaoInter {
  private static final FileFamilyDao fileFamilyDao = new FileFamilyDao();

  private FileFamilyDao() {
  }

  public static FileFamilyDao getInstance() {
    return fileFamilyDao;
  }

  @Override
  public boolean save(List<Family> fs) {
    try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(Util.AppFamilyDbFile))) {
      oo.writeObject(fs);
      return true;
    } catch (IOException e) {
      System.out.println("There is problem with file.");
      return false;
    }
  }

  @Override
  public Optional<List<Family>> load() {
    try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(Util.AppFamilyDbFile))) {
      return Optional.of((List<Family>) oi.readObject());
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("There is nothing in db.");
      return Optional.empty();
    }
  }
}
