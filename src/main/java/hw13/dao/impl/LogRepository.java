package hw13.dao.impl;

import hw13.dao.inter.LogDaoInter;
import hw13.model.enums.Log;
import hw13.util.Util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRepository implements LogDaoInter {
  private static final LogRepository logRepository = new LogRepository();

  private LogRepository() {
  }

  public static LogRepository getInstance(){
    return logRepository;
  }

  @Override
  public boolean save(String message, Log log) {
    File f = new File(Util.LogDbFile);
    if (!f.exists()){
      try {
        if(!f.createNewFile()){
          throw new IOException();
        }
      } catch (IOException e) {
        System.out.println("Can not created Log file.");
        return false;
      }
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))){
      String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
      bw.append(String.format("%s [%s] --- %s\n", formattedDateTime, log.name(), message));
//      System.out.println("LOG SAVED");
      return true;
    } catch (IOException e) {
      System.out.println("There is problem with File writer.");
      return false;
    }
  }
}
