package Dao;
import model.Customer;
import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {

    ArrayList<Customer> customer_list = new ArrayList<>();


    private Customer cus = null;
public ArrayList<Customer> fetchall(){
    try {
        String query = "";
        Connection con = Databaseconnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            customer_list.add(new Customer(rs.getString("name"), rs.getString("address"), rs.getString("phone"), rs.getString("email")));
        }

    }catch (Exception e){
        e.printStackTrace();
    }
    return customer_list;
}

public Customer getCustomer(String emailid){


    try {
        String query = "SELECT * FROM bookstore.Customer Where email = '"+emailid+"'";
        Connection con = Databaseconnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()){
            cus = new Customer(rs.getString("name"), rs.getString("address"), rs.getString("phone"), rs.getString("email"));
        }
    }catch (Exception e){
        e.printStackTrace();
    }

return cus;

}


}
