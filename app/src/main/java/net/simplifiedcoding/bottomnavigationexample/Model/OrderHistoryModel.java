package net.simplifiedcoding.bottomnavigationexample.Model;

public class OrderHistoryModel {
    int Image;
    String Productname;
    String delivery;

    public OrderHistoryModel(int image, String productname, String delivery) {
        Image = image;
        Productname = productname;
        this.delivery = delivery;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
