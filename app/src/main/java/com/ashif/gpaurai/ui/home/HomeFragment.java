package com.ashif.gpaurai.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ashif.gpaurai.R;
import com.ashif.gpaurai.databinding.FragmentHomeBinding;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        textView.setText("_Welcome_\n_Government Polytechnic Aurai_");
        ImageSlider imageslider=root.findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.function, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.girlhostel, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.healthcheckup, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.csback, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.itback, ScaleTypes.CENTER_CROP));

        imageslider.setImageList(slideModels);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}