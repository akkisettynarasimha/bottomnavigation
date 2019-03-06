package net.simplifiedcoding.bottomnavigationexample;

public class Pojo2 {
    String id;

    private String createdtime;
    private String tv_name;
    private String message;
    private String fullpicture;

    public Pojo2() {
    }

    public Pojo2(String id, String createdtime, String tv_name, String message, String fullpicture) {
        this.id = id;
        this.createdtime = createdtime;
        this.tv_name = tv_name;
        this.message = message;
        this.fullpicture = fullpicture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFullpicture() {
        return fullpicture;
    }

    public void setFullpicture(String fullpicture) {
        this.fullpicture = fullpicture;
    }
}
