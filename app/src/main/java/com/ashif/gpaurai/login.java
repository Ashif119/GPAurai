package com.ashif.gpaurai;

import android.content.Intent;
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

import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends Fragment {
    EditText editText1,editText2;
    Button btn;
    ConnectionManager cm;
    String userid="",pswd="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText1=(EditText) view.findViewById(R.id.username);
        editText2=(EditText) view.findViewById(R.id.pass);
        btn=(Button) view.findViewById(R.id.login);
        cm=new ConnectionManager();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userid=editText1.getText().toString();
                pswd=editText2.getText().toString();
                if (userid.length()==0)
                {
                    editText1.requestFocus();
                    editText1.setError("Please Enter Userid");
                }
                else if (pswd.length()==0)
                {
                    editText2.requestFocus();
                    editText2.setError("Please Enter Your Password");
                }
                else
                {
                    String command="select * from log_in where userid='"+userid+"' and pswd='"+pswd+"'";
                    ResultSet resultSet=cm.selectData(command);
                    try {
                        if (resultSet.next()) {
                            Intent intent=new Intent(getActivity(),dashboard.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Invalid Userid Or Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
