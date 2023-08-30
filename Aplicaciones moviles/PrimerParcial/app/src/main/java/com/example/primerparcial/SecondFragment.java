package com.example.primerparcial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.primerparcial.databinding.FragmentSecondBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    EditText articulo;
    EditText descripcion;
    EditText precio;

    FloatingActionButton a;
    FloatingActionButton c;


    View view;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        ProductViewModel model;
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(ProductViewModel.class);
        articulo = (EditText) view.findViewById(R.id.editTextTextPersonName);
        descripcion = (EditText) view.findViewById(R.id.editTextTextPersonName2);
        precio = (EditText) view.findViewById(R.id.editTextTextPersonName3);

        a = (FloatingActionButton) view.findViewById(R.id.floatingActionButton2);
        c = (FloatingActionButton) view.findViewById(R.id.floatingActionButton3);


        a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Product product = new Product(articulo.getText().toString(), descripcion.getText().toString(),Double.parseDouble(precio.getText().toString()));
                model.addProduct(product);
                Snackbar mySnackbar = Snackbar.make(a,
                        "PRODUCTO AGREGADO", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }
        });

        c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                articulo.setText("");
                descripcion.setText("");
                precio.setText("");
            }
        });


    }



}