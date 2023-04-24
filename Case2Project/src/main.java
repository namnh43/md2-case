import menu.MenuManager;
import thread.NewsThread;

public class main {
    public static void main(String[] args) {
        NewsThread thread = new NewsThread("trending");
        thread.start();
        MenuManager menuManager = new MenuManager();
        menuManager.display();
    }
}
