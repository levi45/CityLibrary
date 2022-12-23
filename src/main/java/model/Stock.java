package model;

public class Stock {

    private String code;
    private int ISBN;
    private int quantity;

    public Stock(String code, int ISBN, int quantity) {
        this.code = code;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
