package com.ashif.gpaurai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassward extends AppCompatActivity {
    EditText txtnpass, txtcpass , txtopass;
    Button btn;
    ConnectionManager con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passward);
        btn=(Button) findViewById(R.id.btnchangepswd);
        con=new ConnectionManager();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnpass=(EditText) findViewById(R.id.newpswd);
                txtcpass=(EditText) findViewById(R.id.confirmpswd);
                txtopass=(EditText) findViewById(R.id.oldpswd);
                String npass=txtnpass.getText().toString();
                String cpass=txtcpass.getText().toString();
                String opass=txtopass.getText().toString();
                if(npass.equals(cpass))
                {
                    String command ="update log_in set pswd = '"+npass+"'where pswd = '"+opass+"'";
                    if (con.ExecuteNonQuery(command))
                    {
                        Toast.makeText(ChangePassward.this, "Password Changed Successful", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(ChangePassward.this, "Password not Matched", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}