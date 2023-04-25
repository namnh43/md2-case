import menu.MenuManager;
import thread.NewsThread;

public class main {
    public static void main(String[] args) {
        //Read file
        MenuManager menuManager = new MenuManager();
        NewsThread thread = new NewsThread("trending");
        thread.start();
        menuManager.display();
    }
}
