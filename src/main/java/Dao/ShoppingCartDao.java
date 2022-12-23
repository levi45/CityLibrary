package Dao;

import model.Contains;
import model.Customer;
import model.Product;
import model.ShoppingBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ShoppingCartDao{

    private Customer cus = null;

    public void updateCart(int ISBN, String cart_id, int quantity){
        try {
            String query = " INSERT INTO contain(basket_id, ISBN, quantity) VALUES(?, ?, ?)\n" +
                    "ON DUPLICATE KEY UPDATE\n" +
                    "quantity = quantity+1";
            Connection con = Databaseconnection.getConnection();
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, cart_id);
            preparedStmt.setInt(2, ISBN);
            preparedStmt.setInt(3, quantity);
            preparedStmt.execute();

            con.close();


        }
        catch(Exception e){
            e.printStackTrace();

        }

    }

    public void deleteFromCart(int ISBN,String basket_id){
        String sql = "DELETE FROM bookstore.contain\n" +
                "WHERE ISBN = "+ISBN + " and basket_id = '"+basket_id+"'";
        try {
            Connection con = Databaseconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Contains> fetchall(String basket_id){
        ArrayList<Contains> contains_list = null;
        try {
            String query = "SELECT C.basket_id, C.quantity, B.ISBN, B.title, B.year, B.price, B.publisher_name, B.author FROM bookstore.contain C inner join bookstore.book B on C.ISBN = B.ISBN where C.basket_id = '"+basket_id+"'";
            Connection con = Databaseconnection.getConnection();
            Statement stmt = con.createStatement();
            contains_list = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                contains_list.add(new Contains(new Product(rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getBigDecimal(6),rs.getString(7),rs.getString(8)),new ShoppingBasket(rs.getString(1)),rs.getInt(2)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return contains_list;
    }

}
