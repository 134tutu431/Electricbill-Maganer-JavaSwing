/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class CustomerDAO {

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> list = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select * from CUSTOMERTB";
        try {
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCusid(rs.getString("cusid"));
                customer.setName(rs.getString("name"));
                customer.setPhonenumber(rs.getString("phonenumber"));
                customer.setAddress(rs.getString("address"));
                list.add(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean addCustomer(Customer customer) {
        String sql = "Insert into CUSTOMERTB(cusid,name,phonenumber,address)" + "values(?,?,?,?)";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, customer.getCusid());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getPhonenumber());
            pstmt.setString(4, customer.getAddress());
            return pstmt.executeUpdate()>0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(Customer customer) throws Exception {
        String sql = "UPDATE CUSTOMERTB SET name = ?,phonenumber=?,address=? "+" Where cusid = ?";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(4, customer.getCusid());
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPhonenumber());
            pstmt.setString(3, customer.getAddress());
            return pstmt.executeUpdate()>0;
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(String cusid) throws Exception {
        String sql = "DELETE FROM BILLTB WHERE cusid = ? "+"DELETE FROM CUSTOMERTB WHERE cusid = ? ";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cusid);
            pstmt.setString(2, cusid);
            return pstmt.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Customer findById(String cusid) throws Exception{
        String sql = "Select * from CUSTOMERTB WHERE cusid = ?";
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cusid);
            ResultSet rs =pstmt.executeQuery();
            if(rs.next()) {
                Customer customer = new Customer();
                customer.setCusid(rs.getString("cusid"));
                customer.setName(rs.getString("name"));
                customer.setPhonenumber(rs.getString("phonenumber"));
                customer.setAddress(rs.getString("address"));
                return customer;
            }
            return null;
    }
}
