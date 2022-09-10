package hw13.service;

import hw13.dao.impl.LogRepository;
import hw13.dao.inter.LogDaoInter;
import hw13.model.enums.Log;

public class LogService {
  private static final LogService logService = new LogService();
  private final LogDaoInter logDao = LogRepository.getInstance();

  private LogService() {
  }

  public static LogService getInstance(){
    return logService;
  }

  public boolean info(String message){
    return logDao.save(message, Log.DEBUG);
  }

  public boolean error(String message){
    return logDao.save(message, Log.ERROR);
  }
}
