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
public class BillDAO {

    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> list = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select * from Bills";
        try {
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillid(rs.getString("billid"));
                bill.setCusid(rs.getString("cusid"));
                bill.setOldnum(rs.getInt("oldnum"));
                bill.setNewnum(rs.getInt("newnum"));
                bill.setPay(rs.getFloat("pay"));
                list.add(bill);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean addBill(Bill bill) {
        String sql = "Insert into BILLTB(billid,cusid,oldnum,newnum)" + "values(?,?,?,?)";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bill.getBillid());
            pstmt.setString(2, bill.getCusid());
            pstmt.setInt(3, bill.getNewnum());
            pstmt.setInt(4, bill.getOldnum());
            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Bill findById(String billid) throws Exception {
        String sql = "Select * from BILLTB WHERE billid = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.OpenConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, billid);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Bill bill = new Bill();
            bill.setBillid(rs.getString("billid"));
            bill.setCusid(rs.getString("cusid"));
            bill.setOldnum(rs.getInt("oldnum"));
            bill.setNewnum(rs.getInt("newnum"));    
            return bill;
        }
        return null;
    }

    public boolean deleteBill(String billid) throws Exception {
        String sql = "DELETE FROM BILLTB WHERE billid = ? ";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, billid);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBill(Bill bill) throws Exception {
        String sql = "UPDATE BILLTB SET cusid = ?,oldnum = ?,newnum = ? " + " Where billid = ?";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.OpenConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(4, bill.getBillid());
            pstmt.setString(1, bill.getCusid());
            pstmt.setInt(2, bill.getOldnum());
            pstmt.setInt(3, bill.getNewnum());
            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return false;
    }
}
