package com.ashif.gpaurai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.ResultSet;

public class usermgmt extends AppCompatActivity {
    ConnectionManager con=null;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermgmt);
        con=new ConnectionManager();
        textView=(TextView) findViewById(R.id.txtudata);
        String command ="select * from reg";
        ResultSet resultSet=con.selectData(command);
        String result="";
        try {
            int i=0;
            while (resultSet.next())
            {
                i++;
                result+=i+" .User Details \n \n"+resultSet.getString("Name")+"\n\n";
                result+=resultSet.getString("gender")+"\n\n";
                result+=resultSet.getString("mob")+"\n\n";
                result+=resultSet.getString("email")+"\n\n";
                result+=resultSet.getString("pswrd")+"\n\n";
            }
            textView.setText(result);
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
        }
    }
}