package com.ashif.gpaurai;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class enquiry extends Fragment {
    ConnectionManager cm;
    EditText ename,emob,eemail,msg;
    Button btn;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enquiry,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cm=new ConnectionManager();
        ename=(EditText) view.findViewById(R.id.txtname);
        emob=(EditText) view.findViewById(R.id.txtno);
        eemail=(EditText) view.findViewById(R.id.txtemail);
        msg=(EditText) view.findViewById(R.id.txtmsg);
        btn=(Button) view.findViewById(R.id.btnenq);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(getContext(), ""+cm.getConnection(), Toast.LENGTH_SHORT).show();
                if (ename.getText().toString().equals(""))
                {
                    ename.setHintTextColor(Color.RED);
                    ename.requestFocus();
                    Toast.makeText(getContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }
                else if (emob.getText().toString().equals(""))
                {
                    emob.setHintTextColor(Color.RED);
                    emob.requestFocus();
                    Toast.makeText(getContext(), "Please Enter Your Number", Toast.LENGTH_SHORT).show();
                }
                else if (eemail.getText().toString().equals(""))
                {
                    eemail.setHintTextColor(Color.RED);
                    eemail.requestFocus();
                    Toast.makeText(getContext(), "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                }
                else if (msg.getText().toString().equals(""))
                {
                    msg.setHintTextColor(Color.RED);
                    msg.requestFocus();
                    Toast.makeText(getContext(), "Please Enter You Message", Toast.LENGTH_SHORT).show();
                }
                else {
                    String command = "insert into enquiry values ('" + ename.getText() + "','" + emob.getText() + "','" + eemail.getText() + "','" + msg.getText() + "')";
                    if (cm.ExecuteNonQuery(command)) {
                        Toast.makeText(getContext(), "Thanks for Enquiry", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Error:Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
