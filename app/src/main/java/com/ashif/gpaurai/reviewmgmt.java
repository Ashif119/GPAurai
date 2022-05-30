package com.ashif.gpaurai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.ResultSet;

public class reviewmgmt extends AppCompatActivity {
    ConnectionManager con=null;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewmgmt);
        con=new ConnectionManager();
        textView=(TextView) findViewById(R.id.txtrvdata);
        String command ="select * from review";
        ResultSet resultSet=con.selectData(command);
        String result="";
        try {
            int i=0;
            while (resultSet.next())
            {
                i++;
                result+=i+" .User Details \n \n"+resultSet.getString("ename")+"\n\n";
                result+=resultSet.getString("eemail")+"\n\n";
                result+=resultSet.getString("feedback")+"\n\n";
                result+=resultSet.getString("rate")+"\n\n";
            }
            textView.setText(result);
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
        }
//        cm=new ConnectionManager();
//        rv=new reviewclass();
//        listView=(ListView) findViewById(R.id.lstreview);
//        String command="select * from review";
//        ResultSet resultSet=cm.selectData(command);
//        List<Map<String, String>> data =null;
//        data =new ArrayList<Map<String, String>>();
//
//        try {
//            while (resultSet.next())
//            {
////                Toast.makeText(getApplicationContext(), ""+resultSet.getString("ename"), Toast.LENGTH_SHORT).show();
//                Map<String, String> datanum = new HashMap<String, String>();
//                datanum.put("A", resultSet.getString("ename"));
//                datanum.put("B", resultSet.getString("eemail"));
//                datanum.put("C", resultSet.getString("feedback"));
//                datanum.put("D", resultSet.getString("rate"));
//                data.add(datanum);
//            }
//
//            String[] fromwhere = {"A","B","C","D"};
//            int[] viewswhere = { R.id.txtrname, R.id.txtremail, R.id.txtrfeedback ,R.id.txtrrate};
//            ADAhere = new SimpleAdapter(reviewmgmt.this, data,R.layout.reviews_fragment, fromwhere, viewswhere);
//            listView.setAdapter(ADAhere);
//        }
//        catch (SQLException ex)
//        {
//            Toast.makeText(reviewmgmt.this, ex.getMessage().toString(), Toast.LENGTH_LONG).show();
//            ex.printStackTrace();
//        }
    }
}