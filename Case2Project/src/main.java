import menu.MenuManager;
import thread.NewsThread;

public class main {
    public static void main(String[] args) {
        //Read file
        MenuManager menuManager = new MenuManager();
        NewsThread thread = new NewsThread("trending");
        thread.start();
        menuManager.display();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                // Call some function before the process exits
                someFunction();
            }
        });
    }
    public static void someFunction() {
        // Do some cleanup or shutdown procedure
        System.out.println("EXIT grateful");
    }
}
