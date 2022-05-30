package com.ashif.gpaurai;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.ashif.gpaurai.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private de.hdodenhof.circleimageview.CircleImageView csback , elxback;
    private de.hdodenhof.circleimageview.CircleImageView itback;
//    ViewFlipper slider;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_about, R.id.nav_enquiry, R.id.nav_registration, R.id.nav_login, R.id.nav_share, R.id.nav_review, R.id.nav_faculty)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
//        int imagearray[]={R.drawable.function,R.drawable.girlhostel,R.drawable.healthcheckup,R.drawable.csback,R.drawable.itback};
//        slider=(ViewFlipper)findViewById(R.id.slider);

//        for (int i=0;i<imagearray.length;i++)
//            showimage(imagearray[i]);

        csback=(de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.csback);
        itback=findViewById(R.id.itback);
        elxback=findViewById(R.id.elxback);
        elxback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f3();
            }
        });
        itback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            f2();
            }
        });
        csback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            f1();
            }
        });
    }
    public void f1()
    {
        Intent intent=new Intent(this, com.ashif.gpaurai.csback.class);
        startActivity(intent);
    }
    public void f2()
    {
        Intent intent=new Intent(this, com.ashif.gpaurai.itback.class);
        startActivity(intent);
    }
    public void f3()
    {
        Intent intent=new Intent(this, com.ashif.gpaurai.elxback.class);
        startActivity(intent);
    }
//    public void  showimage(int img)
//    {
//        ImageView imageView=new ImageView(this);
//        imageView.setBackgroundResource(img);
//
//        slider.addView(imageView);
//        slider.setFlipInterval(3000);
//        slider.setAutoStart(true);
//
//
//        slider.setOutAnimation(this, android.R.anim.slide_out_right);
//        slider.setInAnimation(this, android.R.anim.slide_in_left);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuId=item.getItemId();
        if (menuId==R.id.action_settings)
        {
            Intent intent=new Intent(MainActivity.this,myprofile.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder a1=new AlertDialog.Builder(MainActivity.this);
        a1.setMessage("Are You Sure To Exit").setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        })
                .setNegativeButton("No",null);
        AlertDialog c=a1.create();
        c.show();
    }


}