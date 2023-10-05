package com.example.primerparcial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.primerparcial.databinding.ActivityMainBinding;
import com.example.primerparcial.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        if (view == null)
            view = inflater.inflate(R.layout.fragment_first,
                    container, false
            );

        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }



}