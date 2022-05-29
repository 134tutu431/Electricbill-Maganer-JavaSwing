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
public class Bill {

    private String billid;
    private String cusid;
    private int oldnum;
    private int newnum;
    private float pay;

    public Bill(String cusid, String billid, int oldnum, int newnum, float pay) {
        this.cusid = cusid;
        this.billid = billid;
        this.oldnum = oldnum;
        this.newnum = newnum;
        this.pay = pay;
    }

    public Bill() {
    }

    public String getCusid() {
        return cusid;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public String getBillid() {
        return billid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public float getPay() {
        return pay;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public void setOldnum(int oldnum) {
        this.oldnum = oldnum;
    }

    public void setNewnum(int newnum) {
        this.newnum = newnum;
    }

    public int getOldnum() {
        return oldnum;
    }

    public int getNewnum() {
        return newnum;
    }
}
