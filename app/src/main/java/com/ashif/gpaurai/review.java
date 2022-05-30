package com.ashif.gpaurai;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class review extends Fragment {
    EditText et1,et2,et3;
    RatingBar rb;
    Button rbtn;
    ConnectionManager cmr;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.review,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cmr=new ConnectionManager();
        et1=(EditText) view.findViewById(R.id.et1);
        et2=(EditText) view.findViewById(R.id.et2);
        et3=(EditText) view.findViewById(R.id.et3);
        rb=(RatingBar) view.findViewById(R.id.rb1);
        rbtn=(Button) view.findViewById(R.id.rbtn);
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Raview", Toast.LENGTH_SHORT).show();
                if (et1.getText().toString().equals(""))
                {
                    et1.setHintTextColor(Color.RED);
                    et1.requestFocus();
                    Toast.makeText(getContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }
                else if (et2.getText().toString().equals(""))
                {
                    et2.setHintTextColor(Color.RED);
                    et2.requestFocus();
                    Toast.makeText(getContext(), "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                }
                else if (et3.getText().toString().equals(""))
                {
                    et3.setHintTextColor(Color.RED);
                    et3.requestFocus();
                    Toast.makeText(getContext(), "Please Enter Your Message", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    float r=rb.getRating();
                    String command="insert into review values('"+et1.getText()+"','"+et2.getText()+"','"+et3.getText()+"','"+r+"')";
                    boolean x=cmr.ExecuteNonQuery(command);
                    if (x==true)
                    {
                        Toast.makeText(getContext(), "Thanks For ur Valueable Review", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Error:Try Again/Or Your Are Already Given Review", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
