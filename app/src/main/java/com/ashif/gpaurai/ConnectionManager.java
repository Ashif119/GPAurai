package com.ashif.gpaurai;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
    String IP, DB, DBUSERNAME, DBPASSWORD;

    public Connection getConnection() {
        IP = "den1.mssql7.gear.host";
        DB = "gpaurai";
        DBUSERNAME = "gpaurai";
        DBPASSWORD = "Ashif@786";
        Connection con=null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            DriverManager.setLoginTimeout(5000);
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IP + ";databasename=" + DB + ";user=" + DBUSERNAME + ";password=" + DBPASSWORD + ";");

        } catch (Exception ex) {

        }


        return con;

    }
    public boolean ExecuteNonQuery(String command)
    {
        try {
            PreparedStatement ps=getConnection().prepareStatement(command);
            return ps.executeUpdate()>0?true:false;
        } catch (SQLException throwables) {
            return false;
        }
    }

    public ResultSet selectData(String command) {
        try
        {
            PreparedStatement ps=getConnection().prepareStatement(command);
            return ps.executeQuery();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
