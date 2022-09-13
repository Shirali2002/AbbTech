package hw13;

import hw13.ui.impl.Menu;
import hw13.ui.inter.AbstractMenu;

public class App {
  private static final App app = new App();
  private static boolean online;

  private App() {
  }

  public static App getInstance(){
    return app;
  }

  public void start() {
    online = true;
    AbstractMenu menu = Menu.getInstance();
    menu.startMenu();
  }

  public void stop(){
    online = false;
  }

  public static boolean isOnline() {
    return online;
  }
}
