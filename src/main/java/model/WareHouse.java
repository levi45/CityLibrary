package model;

public class WareHouse {

    private String code;
    private String Address;
    private String phone;

    public WareHouse(String code, String address, String phone) {
        this.code = code;
        Address = address;
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
