package model;

import java.util.ArrayList;

public class Contains {
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    Product product;
    ShoppingBasket shoppingBasket;
    int quantity;

    public Contains(Product product, ShoppingBasket shoppingBasket,int quantity) {
        this.product = product;
        this.shoppingBasket = shoppingBasket;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
    this.product = product;
    }

    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    public void setShoppingBasket(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }
}
