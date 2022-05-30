package com.ashif.gpaurai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.ResultSet;

public class enquirymgmt extends AppCompatActivity {
    ConnectionManager con=null;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquirymgmt);
        con=new ConnectionManager();
        textView=(TextView) findViewById(R.id.txtedata);
        String command ="select * from enquiry";
        ResultSet resultSet=con.selectData(command);
        String result="";
        try {
            int i=0;
            while (resultSet.next())
            {
                i++;
                result+=i+" .User Details \n \n"+resultSet.getString("ename")+"\n\n";
                result+=resultSet.getString("emob")+"\n\n";
                result+=resultSet.getString("eemail")+"\n\n";
                result+=resultSet.getString("msg")+"\n\n";
            }
            textView.setText(result);
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
        }

    }
}