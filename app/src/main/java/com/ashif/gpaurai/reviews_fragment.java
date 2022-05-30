package com.ashif.gpaurai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class reviews_fragment extends Fragment {
    TextView textView;
    reviewclass reviewclass;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.reviews_fragment,container,false);
        reviewclass=new reviewclass();
        textView=(TextView) view.findViewById(R.id.txtrname);
        textView.setText(reviewclass.getEname());
        return view;
    }
}
