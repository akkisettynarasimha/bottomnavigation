package net.simplifiedcoding.bottomnavigationexample.Model;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Catogory_Items {
    private String name;
    private int thumbnail;
    private String About;

    public Catogory_Items() {
    }

    public Catogory_Items(String name, int thumbnail, String about) {
        this.name = name;
        this.thumbnail = thumbnail;
        About = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }
}
