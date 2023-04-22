package news;

public class NewsManager {
    private NewsService newsService;

    public NewsManager() {
        newsService = new NewsService();
    }
}
