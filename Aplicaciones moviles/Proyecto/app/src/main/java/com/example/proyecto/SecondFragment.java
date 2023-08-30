package com.example.proyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proyecto.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        getParentFragmentManager().setFragmentResultListener("informacion", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String nombre = result.getString("name");
                String apellido = result.getString("lastName");
                String genero = result.getString("gender");
                String nacimiento = result.getString("birth");
                String RadioGroup1 = result.getString("deci");
                String listString = result.getString("lista");
                TextView text = view.findViewById(R.id.textView4);
                if(RadioGroup1.equalsIgnoreCase("No"))
                    text.setText("Hola!, mi nombre es: " + nombre + " " + apellido + "\n" + "Soy " + genero + " y naci en fecha " + nacimiento + "\n" + "No me gusta programar.");

                if(RadioGroup1.equalsIgnoreCase("Si"))
                    text.setText("Hola!, mi nombre es: " + nombre + " " + apellido + "\n" + "Soy " + genero + " y naci en fecha " + nacimiento + "\n" + "Me gusta programar." + "\n" +"Mis lenguajes favoritos son: " + listString);

            }
        });
        return view;

    }


}