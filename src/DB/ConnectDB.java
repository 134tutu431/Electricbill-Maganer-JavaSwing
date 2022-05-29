/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class ConnectDB implements DatabaseInfo{
    private static ConnectDB instance;

    public ConnectDB() {
    }

    public Connection OpenConnection() throws Exception {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }
    //Get instance of dbms only one time
    public static ConnectDB getInstance(){
        if(instance==null) instance = new ConnectDB();
        return instance;
    }
}
