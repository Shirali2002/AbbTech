package hw13;

import hw13.ui.impl.Menu;
import hw13.ui.inter.AbstractMenu;

public class App {
  private static final App app = new App();
  private static boolean Online;

  private App() {
  }

  public static App getInstance(){
    return app;
  }

  public void start() {
    Online = true;
    AbstractMenu menu = Menu.getInstance();
    menu.startMenu();
  }

  public void stop(){
    Online = false;
  }

  public static boolean isOnline() {
    return Online;
  }
}
