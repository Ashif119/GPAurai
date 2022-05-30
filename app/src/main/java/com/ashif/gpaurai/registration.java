package com.ashif.gpaurai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class registration extends Fragment {
    ConnectionManager cm;
    EditText et1,et2,et3,et4,et5;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Button btn;
    String name="",gen="",mob="",email="",pswd="",cpswd="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registration,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1=(EditText) view.findViewById(R.id.name);
        radioGroup=(RadioGroup) view.findViewById(R.id.rgen);
        et2=(EditText) view.findViewById(R.id.emob);
        et3=(EditText) view.findViewById(R.id.email);
        et4=(EditText) view.findViewById(R.id.pswd);
        et5=(EditText) view.findViewById(R.id.cpswd);
        btn=(Button) view.findViewById(R.id.btnreg);
        cm=new ConnectionManager();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.male:
                    {
                        gen = "Male";
                        break;
                    }
                    case R.id.female:
                    {
                        gen = "Female";
                        break;
                    }
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = et1.getText().toString();
                mob = et2.getText().toString();
                email = et3.getText().toString();
                pswd = et4.getText().toString();
                cpswd = et5.getText().toString();
                String command = "insert into reg values('" + name + "','" + gen + "','"+mob+"','" + email + "','" + pswd + "')";
                if (name.length() == 0) {
                    et1.requestFocus();
                    et1.setError("Please Enter ur Name");
                } else if (mob.length() == 0) {
                    et2.requestFocus();
                    et2.setError("Please Enter ur Number");
                } else if (email.length() == 0) {
                    et3.requestFocus();
                    et3.setError("Please Enter ur Number");
                } else if (pswd.length() == 0) {
                    et4.requestFocus();
                    et4.setError("Please Enter ur Number");
                } else {
                    if (pswd.equals(cpswd)) {
                        boolean x = cm.ExecuteNonQuery(command);
                        if (x==true) {
                            Toast.makeText(getContext(), "Your Registration Is Completed", Toast.LENGTH_SHORT).show();
                            et1.setText("");
                            et2.setText("");
                            et3.setText("");
                            et4.setText("");
                            et5.setText("");
                        } else {
                            Toast.makeText(getContext(), "Your Registration Is Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}

