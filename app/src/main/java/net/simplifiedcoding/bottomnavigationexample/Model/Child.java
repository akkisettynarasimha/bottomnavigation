package net.simplifiedcoding.bottomnavigationexample.Model;

public class Child {
    String name,image,catagory,cost;

    public Child() {
    }

    public Child(String name, String image, String catagory, String cost) {
        this.name = name;
        this.image = image;
        this.catagory = catagory;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
