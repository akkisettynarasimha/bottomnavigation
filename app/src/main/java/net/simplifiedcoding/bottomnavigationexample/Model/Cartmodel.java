package net.simplifiedcoding.bottomnavigationexample.Model;

public class Cartmodel {
    String image,itemname,cost,quantity;

    public Cartmodel(String image, String itemname, String cost, String quantity) {
        this.image = image;
        this.itemname = itemname;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
