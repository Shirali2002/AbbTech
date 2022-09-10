package hw13.controller;

import hw13.dao.impl.LogRepository;
import hw13.dao.inter.LogDaoInter;
import hw13.model.enums.Log;
import hw13.service.LogService;

public class LogController {
  private static final LogController logController = new LogController();
  private final LogService logService = LogService.getInstance();

  private LogController() {
  }

  public static LogController getInstance(){
    return logController;
  }

  public boolean info(String message){
    return logService.info(message);
  }

  public boolean error(String message){
    return logService.error(message);
  }
}
