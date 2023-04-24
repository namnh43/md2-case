package news;

import java.util.Date;

public class NewsStatus {
    private boolean status;
    Date date;

    public NewsStatus(boolean status) {
        this.status = status;
        this.date = new Date();
    }

    public boolean isStatus() {

        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }
}
