package com.ashif.gpaurai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class dashboard extends AppCompatActivity {
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imageButton=findViewById(R.id.logoutb);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }
    public  void logout()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void Changepswd(View view) {
        Intent intent=new Intent(getApplicationContext(),ChangePassward.class);
        startActivity(intent);
    }

    public void usermgmt(View view) {
        Intent intent=new Intent(getApplicationContext(),usermgmt.class);
        startActivity(intent);
    }

    public void enquirymgmt(View view) {
        Intent intent=new Intent(getApplicationContext(),enquirymgmt.class);
        startActivity(intent);
    }

    public void reveiwmgmt(View view) {
        Intent intent=new Intent(getApplicationContext(),reviewmgmt.class);
        startActivity(intent);
    }
}
