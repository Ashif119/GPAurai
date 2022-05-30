package com.ashif.gpaurai;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class share extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"http://gpaurai.ac.in/");
        intent.putExtra(Intent.EXTRA_SUBJECT,"http://gpaurai.ac.in/");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,"Share From My GP Aurai App"));
        return inflater.inflate(R.layout.share,container,false);

    }
}
