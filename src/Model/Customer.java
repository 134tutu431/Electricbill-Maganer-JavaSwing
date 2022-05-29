/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author HP
 */
public class Customer {

    private String cusid;
    private String name;
    private String phonenumber;
    private String address;

    public Customer(String cusid, String name, String phonenumber, String address) {
        this.cusid = cusid;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public Customer() {
    }

    public String getCusid() {
        return cusid;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
