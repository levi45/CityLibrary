package model;

public class ShoppingBasket{

    private String basket_id;


    public ShoppingBasket(String basket_id) {
        this.basket_id = basket_id;
    }

    public String getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(String basket_id) {
        this.basket_id = basket_id;
    }
}
