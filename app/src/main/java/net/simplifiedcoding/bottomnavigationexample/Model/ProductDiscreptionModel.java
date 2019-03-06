package net.simplifiedcoding.bottomnavigationexample.Model;


public class ProductDiscreptionModel {
    String product,productname;

    public ProductDiscreptionModel(String product, String productname) {
        this.product = product;
        this.productname = productname;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}
